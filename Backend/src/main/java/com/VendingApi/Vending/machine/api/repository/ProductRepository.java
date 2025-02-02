package com.VendingApi.Vending.machine.api.repository;

import com.VendingApi.Vending.machine.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
