package com.VendingApi.Vending.machine.api.service.Impl;

import com.VendingApi.Vending.machine.api.Dto.ProductDTO;
import com.VendingApi.Vending.machine.api.Dto.TransactionDTO;
import com.VendingApi.Vending.machine.api.Enums.TransactionStatus;
import com.VendingApi.Vending.machine.api.entity.Product;
import com.VendingApi.Vending.machine.api.entity.ProductPurchase;
import com.VendingApi.Vending.machine.api.entity.Transaction;
import com.VendingApi.Vending.machine.api.exception.ResourceNotFoundException;
import com.VendingApi.Vending.machine.api.mapper.TransactionMapper;
import com.VendingApi.Vending.machine.api.repository.ProductRepository;
import com.VendingApi.Vending.machine.api.repository.TransactionRepository;
import com.VendingApi.Vending.machine.api.service.CashInventoryService;
import com.VendingApi.Vending.machine.api.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final CashInventoryService cashInventoryService;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            ProductRepository productRepository,
            CashInventoryService cashInventoryService) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.cashInventoryService = cashInventoryService;
    }

    @Override
    public TransactionDTO processTransaction(List<ProductDTO> products, BigDecimal amountPaid) {
        // Calculate total amount
        double totalAmount = calculateTotal(products);

        // Check if payment is sufficient
        if (amountPaid.doubleValue() < totalAmount) {
            throw new IllegalArgumentException("Insufficient payment amount");
        }

        // Create new transaction
        Transaction transaction = new Transaction();
        transaction.setTotalAmount(totalAmount);
        transaction.setAmountPaid(amountPaid.doubleValue());
        transaction.setChangeAmount(amountPaid.doubleValue() - totalAmount);
        transaction.setStatus(TransactionStatus.COMPLETED);
        transaction.setTimestamp(LocalDateTime.now());

        // Create product purchases
        List<ProductPurchase> purchases = new ArrayList<>();
        for (ProductDTO productDTO : products) {
            Product product = productRepository.findById(productDTO.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

            // Check stock
            if (product.getStockQuantity() <= 0) {
                throw new IllegalStateException("Product out of stock: " + product.getName());
            }

            // Create purchase
            ProductPurchase purchase = new ProductPurchase();
            purchase.setProduct(product);
            purchase.setQuantity(1);
            purchase.setPriceAtPurchase(product.getPrice());
            purchases.add(purchase);

            // Update stock
            product.setStockQuantity(product.getStockQuantity() - 1);
            productRepository.save(product);
        }

        transaction.setItems(purchases);

        Transaction savedTransaction = transactionRepository.save(transaction);
        return TransactionMapper.mapToTransactionDTO(savedTransaction);
    }

    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
        return TransactionMapper.mapToTransactionDTO(transaction);
    }

    @Override
    public List<TransactionDTO> getTransactionHistory() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(TransactionMapper::mapToTransactionDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<TransactionDTO> getTransactionsByStatus(TransactionStatus status) {
        List<Transaction> transactions = transactionRepository.findByStatus(status);
        return transactions.stream()
                .map(TransactionMapper::mapToTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> getTransactionsBetweenDates(LocalDateTime start, LocalDateTime end) {
        List<Transaction> transactions = transactionRepository.findByTimestampBetween(start, end);
        return transactions.stream()
                .map(TransactionMapper::mapToTransactionDTO)
                .collect(Collectors.toList());
    }

    private double calculateTotal(List<ProductDTO> products) {
        return products.stream()
                .mapToDouble(ProductDTO::getPrice)
                .sum();

    }
}
