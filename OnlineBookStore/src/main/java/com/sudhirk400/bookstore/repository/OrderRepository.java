package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Order;

/**
 * The Interface OrderRepository.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
