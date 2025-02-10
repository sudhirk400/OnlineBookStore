package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhirk400.bookstore.model.Cart;

/**
 * The Interface CartRepository.
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	/**
	 * Find by customer email.
	 *
	 * @param email the email
	 * @return the cart
	 */
	Cart findByCustomerEmail(String email);
}