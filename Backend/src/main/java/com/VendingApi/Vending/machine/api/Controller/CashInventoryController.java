package com.VendingApi.Vending.machine.api.Controller;

import com.VendingApi.Vending.machine.api.Dto.CashInventoryDTO;
import com.VendingApi.Vending.machine.api.Enums.Denomination;
import com.VendingApi.Vending.machine.api.service.CashInventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cash-inventory")
public class CashInventoryController {
    private final CashInventoryService cashInventoryService;

    public CashInventoryController(CashInventoryService cashInventoryService) {
        this.cashInventoryService = cashInventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCash(@RequestBody CashInventoryDTO cashInventoryDTO) {
        cashInventoryService.addCash(cashInventoryDTO.getDenomination(), cashInventoryDTO.getQuantity());
        return new ResponseEntity<>("Cash added successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeCash(@RequestBody CashInventoryDTO cashInventoryDTO) {
        cashInventoryService.removeCash(cashInventoryDTO.getDenomination(), cashInventoryDTO.getQuantity());
        return ResponseEntity.ok("Cash removed successfully!");
    }


    @GetMapping("/change-possible")
    public ResponseEntity<Boolean> canProvideChange(@RequestParam BigDecimal changeAmount) {
        boolean canProvide = cashInventoryService.canProvideChange(changeAmount);
        return ResponseEntity.ok(canProvide);
    }

    @PostMapping("/calculate-change")
    public ResponseEntity<Map<Denomination, Integer>> calculateChange(@RequestParam BigDecimal changeAmount) {
        Map<Denomination, Integer> change = cashInventoryService.calculateChange(changeAmount);
        return ResponseEntity.ok(change);
    }

    @GetMapping("/current")
    public ResponseEntity<List<CashInventoryDTO>> getCurrentInventory() {
        List<CashInventoryDTO> inventory = cashInventoryService.getCurrentInventory();
        return ResponseEntity.ok(inventory);
    }
}
