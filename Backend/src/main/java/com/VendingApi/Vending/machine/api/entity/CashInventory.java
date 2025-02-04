package com.VendingApi.Vending.machine.api.entity;

import com.VendingApi.Vending.machine.api.Enums.Denomination;
import jakarta.persistence.*;

@Entity
@Table(name = "cash_inventory")
public class CashInventory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        @Column(name = "denomination")
        private Denomination denomination;

        @Column(name = "quantity")
        private int quantity;



    public CashInventory() {
    }

    public CashInventory(Long id, Denomination denomination, int quantity) {
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
