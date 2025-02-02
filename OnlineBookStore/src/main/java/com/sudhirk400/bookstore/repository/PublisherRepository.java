package com.sudhirk400.bookstore.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Publisher;
 

/**
 * The Interface PublisherRepository.
 */
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
