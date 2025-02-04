package com.VendingApi.Vending.machine.api.service.Impl;

import com.VendingApi.Vending.machine.api.Dto.CashInventoryDTO;
import com.VendingApi.Vending.machine.api.Enums.Denomination;
import com.VendingApi.Vending.machine.api.entity.CashInventory;
import com.VendingApi.Vending.machine.api.exception.ResourceNotFoundException;
import com.VendingApi.Vending.machine.api.mapper.CashInventoryMapper;
import com.VendingApi.Vending.machine.api.repository.CashInventoryRepository;
import com.VendingApi.Vending.machine.api.service.CashInventoryService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CashInventoryServiceImpl implements CashInventoryService {


    private final CashInventoryRepository cashInventoryRepository;

    public CashInventoryServiceImpl(CashInventoryRepository cashInventoryRepository) {
        this.cashInventoryRepository = cashInventoryRepository;
    }


    @Override
    public void addCash(Denomination denomination, int quantity) {

        CashInventory cashInventory = cashInventoryRepository.findByDenomination(denomination)
                .orElse(new CashInventory(null, denomination, 0));

        cashInventory.setQuantity(cashInventory.getQuantity() + quantity);
        cashInventoryRepository.save(cashInventory);
    }

    @Override
    public void removeCash(Denomination denomination, int quantity) {

        CashInventory cashInventory = cashInventoryRepository.findByDenomination(denomination)
                .orElseThrow(() -> new ResourceNotFoundException("Denomination not found: " + denomination));

        if (cashInventory.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient cash for denomination: " + denomination);
        }

        cashInventory.setQuantity(cashInventory.getQuantity() - quantity);
        cashInventoryRepository.save(cashInventory);
    }

    @Override
    public boolean canProvideChange(BigDecimal changeAmount) {
        try {
            Map<Denomination, Integer> change = calculateChange(changeAmount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Map<Denomination, Integer> calculateChange(BigDecimal changeAmount) {
        List<CashInventory> availableCash = cashInventoryRepository.findAllByOrderByDenominationDesc();
        Map<Denomination, Integer> changeMap = new HashMap<>();
        double remainingAmount = changeAmount.doubleValue();

        for (CashInventory cash : availableCash) {
            if (remainingAmount <= 0) break;

            double denominationValue = cash.getDenomination().getValue();
            int neededCount = (int) (remainingAmount / denominationValue);
            int actualCount = Math.min(neededCount, cash.getQuantity());

            if (actualCount > 0) {
                changeMap.put(cash.getDenomination(), actualCount);
                remainingAmount -= (denominationValue * actualCount);
                remainingAmount = Math.round(remainingAmount * 100.0) / 100.0; // Round to 2 decimal places
            }
        }

        if (remainingAmount > 0.01) {
            throw new IllegalStateException("Cannot provide exact change");
        }

        // Update inventory
        for (Map.Entry<Denomination, Integer> entry : changeMap.entrySet()) {
            removeCash(entry.getKey(), entry.getValue());
        }

        return changeMap;
    }

    @Override
    public List<CashInventoryDTO> getCurrentInventory() {
        List<CashInventory> inventory = cashInventoryRepository.findAll();
        return inventory.stream()
                .map(CashInventoryMapper::mapToCashInventoryDTO)
                .collect(Collectors.toList());
    }
}
