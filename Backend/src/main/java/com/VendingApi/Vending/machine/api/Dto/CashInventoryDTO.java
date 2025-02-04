package com.VendingApi.Vending.machine.api.Dto;

import com.VendingApi.Vending.machine.api.Enums.Denomination;
import com.VendingApi.Vending.machine.api.entity.CashInventory;

public class CashInventoryDTO {
    private Long id;
    private Denomination denomination;
    private int quantity;

    public CashInventoryDTO(){}

    public CashInventoryDTO(Long id, Denomination denomination, int quantity) {
        this.id = id;
        this.denomination = denomination;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
