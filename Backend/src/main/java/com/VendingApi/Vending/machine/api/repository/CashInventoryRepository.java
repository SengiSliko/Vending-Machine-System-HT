package com.VendingApi.Vending.machine.api.repository;

import com.VendingApi.Vending.machine.api.Enums.Denomination;
import com.VendingApi.Vending.machine.api.entity.CashInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CashInventoryRepository extends JpaRepository<CashInventory,Long> {
    Optional<CashInventory> findByDenomination(Denomination denomination);
    List<CashInventory> findAllByOrderByDenominationDesc();
}
