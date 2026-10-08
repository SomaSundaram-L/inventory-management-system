package org.example.inventorytask3.controller;

import org.example.inventorytask3.entity.Inventory;
import org.example.inventorytask3.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Add Inventory
    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    // View All Inventory
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    // View Inventory by ID
    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    // Update Inventory
    @PutMapping("/{id}")
    public Inventory updateInventory(
            @PathVariable Long id,
            @RequestBody Inventory inventory) {

        return inventoryService.updateInventory(id, inventory);
    }

    // Delete Inventory
    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {

        inventoryService.deleteInventory(id);

        return "Inventory deleted successfully";
    }

    // Search by Product Name
    @GetMapping("/search")
    public List<Inventory> searchByProductName(
            @RequestParam String productName) {

        return inventoryService.searchByProductName(productName);
    }

    // Filter by Category
    @GetMapping("/category")
    public List<Inventory> filterByCategory(
            @RequestParam String category) {

        return inventoryService.filterByCategory(category);
    }
}