package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
