/**
 * 
 */
package com.sudhirk400.bookstore.service;

import java.util.ArrayList;
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
    	
    	Book book  = new Book("1234567890", "Java Programming", "John Doe", "Programming", 49.99, 100);
    	List<Book> books = new ArrayList<Book>();
    	books.add(book);
    	book  = new Book("0123456789", "Programming in Java", "S S Khandare", "Programming", 29.99, 101);
    	books.add(book);
    	return books;
    	
    }

    public Book getBookById(Long id) {
        // Fetch a book by id and map to DTO
    	return  new Book("1234567890", "Java Programming", "John Doe", "Programming", 49.99, 100);
    }

    public Book createBook(Book book) {
        // Save the new book and return the saved DTO
    	return new Book("0123456789", "Programming in Java", "S S Khandare", "Programming", 29.99, 101);
    }

    public Book updateBook(Long id, Book book) {
        // Update the book with the given id and return the updated DTO
    	return null;
    }

    public void deleteBook(Long id) {
        // Delete the book by id
    }	
}
