package com.VendingApi.Vending.machine.api.Controller;

import com.VendingApi.Vending.machine.api.Dto.ProductPurchaseDTO;
import com.VendingApi.Vending.machine.api.service.ProductPurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-purchases")
public class ProductPurchaseController {

    private final ProductPurchaseService productPurchaseService;

    public ProductPurchaseController(ProductPurchaseService productPurchaseService) {
        this.productPurchaseService = productPurchaseService;
    }

    @PostMapping
    public ResponseEntity<ProductPurchaseDTO> createProductPurchase(@RequestBody ProductPurchaseDTO productPurchaseDTO) {
        ProductPurchaseDTO savedPurchase = productPurchaseService.createProductPurchase(productPurchaseDTO);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<ProductPurchaseDTO> getProductPurchaseById(@PathVariable("id") Long id) {
        ProductPurchaseDTO productPurchase = productPurchaseService.getProductPurchaseById(id);
        return ResponseEntity.ok(productPurchase);
    }


    @GetMapping
    public ResponseEntity<List<ProductPurchaseDTO>> getAllProductPurchases() {
        List<ProductPurchaseDTO> productPurchases = productPurchaseService.getAllProductPurchases();
        return ResponseEntity.ok(productPurchases);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductPurchaseDTO> updateProductPurchase(
            @PathVariable("id") Long id,
            @RequestBody ProductPurchaseDTO productPurchaseDTO) {
        ProductPurchaseDTO updatedPurchase = productPurchaseService.updateProductPurchase(id, productPurchaseDTO);
        return ResponseEntity.ok(updatedPurchase);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductPurchase(@PathVariable("id") Long id) {
        productPurchaseService.deleteProductPurchase(id);
        return ResponseEntity.ok("Product Purchase deleted successfully!");
    }

}
