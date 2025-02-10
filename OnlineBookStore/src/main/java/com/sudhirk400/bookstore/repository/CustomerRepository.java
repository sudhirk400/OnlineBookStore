package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Customer;

/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the customer
	 */
	Customer findByEmail(String email);
}
