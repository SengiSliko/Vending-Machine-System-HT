package com.VendingApi.Vending.machine.api.service;

import com.VendingApi.Vending.machine.api.Dto.CashInventoryDTO;
import com.VendingApi.Vending.machine.api.Enums.Denomination;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CashInventoryService {
    void addCash(Denomination denomination, int quantity);
    void removeCash(Denomination denomination, int quantity);
    boolean canProvideChange(BigDecimal changeAmount);
    Map<Denomination, Integer> calculateChange(BigDecimal changeAmount);
    List<CashInventoryDTO> getCurrentInventory();

}
