package com.sudhirk400.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Inventory;
import com.sudhirk400.bookstore.repository.InventoryRepository;

import java.util.List;

 
/**
 * The Class InventoryService.
 */
@Service
public class InventoryService {

    /** The inventory repository. */
    @Autowired
    private InventoryRepository inventoryRepository;

    /**
     * Gets the all inventory.
     *
     * @return the all inventory
     */
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    /**
     * Gets the inventory by book ID.
     *
     * @param bookID the book ID
     * @return the inventory by book ID
     */
    public Inventory getInventoryByBookID(Integer bookID) {
        return inventoryRepository.findById(bookID).orElse(null);
    }

    /**
     * Save inventory.
     *
     * @param inventory the inventory
     * @return the inventory
     */
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    /**
     * Delete inventory by book ID.
     *
     * @param bookID the book ID
     */
    public void deleteInventoryByBookID(Integer bookID) {
        inventoryRepository.deleteById(bookID);
    }
}

