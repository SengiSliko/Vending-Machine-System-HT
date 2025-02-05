package com.VendingApi.Vending.machine.api.Controller;

import com.VendingApi.Vending.machine.api.Dto.ProductDTO;
import com.VendingApi.Vending.machine.api.Dto.TransactionDTO;
import com.VendingApi.Vending.machine.api.Dto.TransactionRequestDTO;
import com.VendingApi.Vending.machine.api.Enums.TransactionStatus;
import com.VendingApi.Vending.machine.api.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/process")
    public ResponseEntity<TransactionDTO> processTransaction(@RequestBody TransactionRequestDTO request) {
        TransactionDTO transaction = transactionService.processTransaction(request.getProducts(), request.getAmountPaid());
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable("id") Long transactionId) {
        TransactionDTO transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/history")
    public ResponseEntity<List<TransactionDTO>> getTransactionHistory() {
        List<TransactionDTO> transactions = transactionService.getTransactionHistory();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByStatus(
            @PathVariable TransactionStatus status) {
        List<TransactionDTO> transactions = transactionService.getTransactionsByStatus(status);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<TransactionDTO>> getTransactionsBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<TransactionDTO> transactions = transactionService.getTransactionsBetweenDates(start, end);
        return ResponseEntity.ok(transactions);
    }



}
