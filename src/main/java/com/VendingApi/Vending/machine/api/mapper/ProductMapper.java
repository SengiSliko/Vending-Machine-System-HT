package com.VendingApi.Vending.machine.api.mapper;

import com.VendingApi.Vending.machine.api.Dto.ProductDTO;
import com.VendingApi.Vending.machine.api.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToProductDto(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getColor(),
                product.getImage()
        );
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getStockQuantity(),
                productDTO.getColor(),
                productDTO.getImage()
        );
    }
}
