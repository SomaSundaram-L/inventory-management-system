package org.example.inventorytask3.repository;

import org.example.inventorytask3.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByProductNameContainingIgnoreCase(String productName);

    List<Inventory> findByCategoryContainingIgnoreCase(String category);
}