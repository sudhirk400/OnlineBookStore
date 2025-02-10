package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhirk400.bookstore.model.Payment;

/**
 * The Interface PaymentRepository.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
