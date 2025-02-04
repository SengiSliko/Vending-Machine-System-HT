package com.VendingApi.Vending.machine.api.service.Impl;

import com.VendingApi.Vending.machine.api.Dto.ProductPurchaseDTO;
import com.VendingApi.Vending.machine.api.entity.ProductPurchase;
import com.VendingApi.Vending.machine.api.exception.ResourceNotFoundException;
import com.VendingApi.Vending.machine.api.mapper.ProductPurchaseMapper;
import com.VendingApi.Vending.machine.api.repository.ProductPurchaseRepository;
import com.VendingApi.Vending.machine.api.service.ProductPurchaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductPurchaseServiceImpl implements ProductPurchaseService {

    private final ProductPurchaseRepository productPurchaseRepository;


    public ProductPurchaseServiceImpl(ProductPurchaseRepository productPurchaseRepository) {
        this.productPurchaseRepository = productPurchaseRepository;
    }


    @Override
    public ProductPurchaseDTO createProductPurchase(ProductPurchaseDTO productPurchaseDTO) {
        ProductPurchase productPurchase = ProductPurchaseMapper.mapToProductPurchase(productPurchaseDTO);
        ProductPurchase savedProductPurchase = productPurchaseRepository.save(productPurchase);
        return ProductPurchaseMapper.mapToProductPurchaseDto(savedProductPurchase);
    }

    @Override
    public ProductPurchaseDTO getProductPurchaseById(Long id) {
        ProductPurchase productPurchase = productPurchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Purchase not found with id: " + id));
        return ProductPurchaseMapper.mapToProductPurchaseDto(productPurchase);

    }

    @Override
    public List<ProductPurchaseDTO> getAllProductPurchases() {
        List<ProductPurchase> productPurchases = productPurchaseRepository.findAll();
        return productPurchases.stream()
                .map(ProductPurchaseMapper::mapToProductPurchaseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductPurchaseDTO updateProductPurchase(Long id, ProductPurchaseDTO productPurchaseDTO) {
        ProductPurchase existingPurchase = productPurchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Purchase not found with id: " + id));

        existingPurchase.setProduct(productPurchaseDTO.getProduct());
        existingPurchase.setQuantity(productPurchaseDTO.getQuantity());
        existingPurchase.setPriceAtPurchase(productPurchaseDTO.getPriceAtPurchase());

        ProductPurchase updatedPurchase = productPurchaseRepository.save(existingPurchase);
        return ProductPurchaseMapper.mapToProductPurchaseDto(updatedPurchase);
    }

    @Override
    public void deleteProductPurchase(Long id) {
        if (!productPurchaseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product Purchase not found with id: " + id);
        }
        productPurchaseRepository.deleteById(id);
    }
}
