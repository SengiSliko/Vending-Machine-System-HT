package com.VendingApi.Vending.machine.api.Dto;

import java.math.BigDecimal;
import java.util.List;

public class TransactionRequestDTO {

    private List<ProductDTO> products;
    private BigDecimal amountPaid;

    public TransactionRequestDTO() {}

    public TransactionRequestDTO(List<ProductDTO> products, BigDecimal amountPaid) {
        this.products = products;
        this.amountPaid = amountPaid;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }
}

