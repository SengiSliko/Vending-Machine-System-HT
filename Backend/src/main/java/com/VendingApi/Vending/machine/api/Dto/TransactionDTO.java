package com.VendingApi.Vending.machine.api.Dto;

import com.VendingApi.Vending.machine.api.Enums.TransactionStatus;
import com.VendingApi.Vending.machine.api.entity.ProductPurchase;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDTO {
    private Long id;
    private List<ProductPurchase> items;
    private double totalAmount;
    private double amountPaid;
    private double changeAmount;
    private TransactionStatus status;
    private LocalDateTime timestamp;


    public TransactionDTO() {

    }

    public TransactionDTO(Long id, List<ProductPurchase> items, double totalAmount, double amountPaid, double changeAmount, TransactionStatus status, LocalDateTime timestamp) {
        this.id = id;
        this.items = items;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.changeAmount = changeAmount;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductPurchase> getItems() {
        return items;
    }

    public void setItems(List<ProductPurchase> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(double changeAmount) {
        this.changeAmount = changeAmount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
