package com.VendingApi.Vending.machine.api.service;

import com.VendingApi.Vending.machine.api.Dto.ProductPurchaseDTO;

import java.util.List;

public interface ProductPurchaseService {
    ProductPurchaseDTO createProductPurchase(ProductPurchaseDTO productPurchaseDTO);
    ProductPurchaseDTO getProductPurchaseById(Long id);
    List<ProductPurchaseDTO> getAllProductPurchases();
    ProductPurchaseDTO updateProductPurchase(Long id, ProductPurchaseDTO productPurchaseDTO);
    void deleteProductPurchase(Long id);

}
