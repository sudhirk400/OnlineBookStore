package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
