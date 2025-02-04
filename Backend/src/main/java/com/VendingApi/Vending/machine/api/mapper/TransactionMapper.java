package com.VendingApi.Vending.machine.api.mapper;

import com.VendingApi.Vending.machine.api.Dto.TransactionDTO;
import com.VendingApi.Vending.machine.api.entity.Transaction;

import java.util.stream.Collectors;

public class TransactionMapper {

    public static TransactionDTO mapToTransactionDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getItems(), // Directly use items
                transaction.getTotalAmount(),
                transaction.getAmountPaid(),
                transaction.getChangeAmount(),
                transaction.getStatus(),
                transaction.getTimestamp()
        );
    }

    public static Transaction mapToTransaction(TransactionDTO dto) {
        return new Transaction(
                dto.getId(),
                dto.getItems(), // Directly use items
                dto.getTotalAmount(),
                dto.getAmountPaid(),
                dto.getChangeAmount(),
                dto.getStatus(),
                dto.getTimestamp()
        );
    }
}
