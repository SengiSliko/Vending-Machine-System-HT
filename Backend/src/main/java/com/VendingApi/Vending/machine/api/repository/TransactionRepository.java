package com.VendingApi.Vending.machine.api.repository;

import com.VendingApi.Vending.machine.api.Enums.TransactionStatus;
import com.VendingApi.Vending.machine.api.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository  extends JpaRepository<Transaction,Long> {
    List<Transaction> findByStatus(TransactionStatus status);
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
