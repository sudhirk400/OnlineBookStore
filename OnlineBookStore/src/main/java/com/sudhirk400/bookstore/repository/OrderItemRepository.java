package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.OrderItem;
import com.sudhirk400.bookstore.model.OrderItemKey;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}
