package com.VendingApi.Vending.machine.api.service;

import com.VendingApi.Vending.machine.api.Dto.ProductDTO;
import com.VendingApi.Vending.machine.api.Dto.TransactionDTO;
import com.VendingApi.Vending.machine.api.Enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    TransactionDTO processTransaction(List<ProductDTO> products, BigDecimal amountPaid);
    TransactionDTO getTransactionById(Long transactionId);
    List<TransactionDTO> getTransactionHistory();
    List<TransactionDTO> getTransactionsByStatus(TransactionStatus status);
    List<TransactionDTO> getTransactionsBetweenDates(LocalDateTime start, LocalDateTime end);
}
