package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
