package com.VendingApi.Vending.machine.api.repository;

import com.VendingApi.Vending.machine.api.entity.ProductPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase,Long> {
}
