package com.VendingApi.Vending.machine.api.mapper;

import com.VendingApi.Vending.machine.api.Dto.ProductPurchaseDTO;
import com.VendingApi.Vending.machine.api.entity.ProductPurchase;

public class ProductPurchaseMapper {

    public static ProductPurchaseDTO mapToProductPurchaseDto(ProductPurchase productPurchase) {
        return new ProductPurchaseDTO(
                productPurchase.getId(),
                productPurchase.getProduct(),
                productPurchase.getQuantity(),
                productPurchase.getPriceAtPurchase()
        );
    }

    public static ProductPurchase mapToProductPurchase(ProductPurchaseDTO dto) {
        return new ProductPurchase(
                dto.getId(),
                dto.getProduct(),
                dto.getQuantity(),
                dto.getPriceAtPurchase()
        );
    }
}
