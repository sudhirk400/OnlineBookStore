package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhirk400.bookstore.model.CartItem;

import java.util.List;

/**
 * The Interface CartItemRepository.
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
