package com.VendingApi.Vending.machine.api.Dto;

import com.VendingApi.Vending.machine.api.entity.Product;

public class ProductPurchaseDTO {
    private long id;
    private Product product;
    private int quantity;
    private double priceAtPurchase;

    public ProductPurchaseDTO() {}

    public ProductPurchaseDTO(long id, Product product, int quantity, double priceAtPurchase) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }
}
