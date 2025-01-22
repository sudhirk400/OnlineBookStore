/**
 * 
 */
package com.sudhirk400.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Book;

/**
 * 
 */
@Service
public class BookService {

    // Assuming a BookRepository is already defined for data operations

    public List<Book> getAllBooks() {
        // Fetch all books from the repository and map to DTOs
    	return null;
    	
    }

    public Book getBookById(Long id) {
        // Fetch a book by id and map to DTO
    	return null;
    }

    public Book createBook(Book book) {
        // Save the new book and return the saved DTO
    	return null;
    }

    public Book updateBook(Long id, Book book) {
        // Update the book with the given id and return the updated DTO
    	return null;
    }

    public void deleteBook(Long id) {
        // Delete the book by id
    }	
}
