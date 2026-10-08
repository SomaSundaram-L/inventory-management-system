package org.example.inventorytask3.service;

import org.example.inventorytask3.entity.Inventory;
import org.example.inventorytask3.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Add Inventory
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // View All Inventory
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // View Inventory by ID
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    // Update Inventory
    public Inventory updateInventory(Long id, Inventory inventory) {

        Inventory existingInventory =
                inventoryRepository.findById(id).orElse(null);

        if (existingInventory != null) {

            existingInventory.setProductName(inventory.getProductName());
            existingInventory.setCategory(inventory.getCategory());
            existingInventory.setQuantity(inventory.getQuantity());
            existingInventory.setPrice(inventory.getPrice());
            existingInventory.setSupplier(inventory.getSupplier());

            return inventoryRepository.save(existingInventory);
        }

        return null;
    }

    // Delete Inventory
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    // Search by Product Name
    public List<Inventory> searchByProductName(String productName) {
        return inventoryRepository
                .findByProductNameContainingIgnoreCase(productName);
    }

    // Filter by Category
    public List<Inventory> filterByCategory(String category) {
        return inventoryRepository
                .findByCategoryContainingIgnoreCase(category);
    }
}