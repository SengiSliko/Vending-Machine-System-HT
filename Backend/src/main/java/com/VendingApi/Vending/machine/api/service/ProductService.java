package com.VendingApi.Vending.machine.api.service;

import com.VendingApi.Vending.machine.api.Dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO getProductById(Long productId);
    List<ProductDTO> getAllProducts();
    ProductDTO updateProduct(Long productId, ProductDTO updatedProduct);
    void deleteProduct(Long productId);
}
