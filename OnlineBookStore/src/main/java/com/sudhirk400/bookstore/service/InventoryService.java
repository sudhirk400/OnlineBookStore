package com.sudhirk400.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Inventory;
import com.sudhirk400.bookstore.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryByBookID(Integer bookID) {
        return inventoryRepository.findById(bookID).orElse(null);
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventoryByBookID(Integer bookID) {
        inventoryRepository.deleteById(bookID);
    }
}

