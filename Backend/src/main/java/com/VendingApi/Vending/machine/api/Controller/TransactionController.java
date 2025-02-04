package com.VendingApi.Vending.machine.api.Controller;

import com.VendingApi.Vending.machine.api.Dto.ProductDTO;
import com.VendingApi.Vending.machine.api.Dto.TransactionDTO;
import com.VendingApi.Vending.machine.api.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/process")
    public ResponseEntity<TransactionDTO> processTransaction(
            @RequestBody List<ProductDTO> products,
            @RequestParam BigDecimal amountPaid) {
        TransactionDTO transaction = transactionService.processTransaction(products, amountPaid);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable("id") Long transactionId) {
        TransactionDTO transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }

}
