package com.VendingApi.Vending.machine.api.mapper;

import com.VendingApi.Vending.machine.api.Dto.CashInventoryDTO;
import com.VendingApi.Vending.machine.api.entity.CashInventory;

public class CashInventoryMapper {

    public static CashInventoryDTO mapToCashInventoryDTO(CashInventory cashInventory) {
        return new CashInventoryDTO(
                cashInventory.getId(),
                cashInventory.getDenomination(),
                cashInventory.getQuantity()
        );
    }

    public static CashInventory mapToCashInventory(CashInventoryDTO dto) {
        return new CashInventory(
                dto.getId(),
                dto.getDenomination(),
                dto.getQuantity()
        );
    }
}
