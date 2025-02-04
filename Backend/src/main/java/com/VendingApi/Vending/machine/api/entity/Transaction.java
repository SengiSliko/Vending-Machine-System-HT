package com.VendingApi.Vending.machine.api.entity;

import com.VendingApi.Vending.machine.api.Enums.TransactionStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private List<ProductPurchase> items;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "amount_paid")
    private double amountPaid;

    @Column(name = "change_amount")
    private double changeAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;


    public Transaction() {

    }

    public Transaction(Long id, List<ProductPurchase> items, double totalAmount, double amountPaid, double changeAmount, TransactionStatus status, LocalDateTime timestamp) {
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
