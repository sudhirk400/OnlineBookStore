package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Author;

/**
 * The Interface AuthorRepository.
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

