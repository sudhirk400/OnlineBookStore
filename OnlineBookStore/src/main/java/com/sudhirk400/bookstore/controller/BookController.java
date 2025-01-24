/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhirk400.bookstore.model.Book;
import com.sudhirk400.bookstore.service.BookService;

import jakarta.annotation.security.RolesAllowed;

//import jakarta.annotation.security.RolesAllowed;

/**
 * 
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	@RolesAllowed({"Admin","Customer"})
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	@RolesAllowed({"Admin","Customer"})
	//@RolesAllowed("Customer")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@PostMapping 
	//@RolesAllowed("Admin")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@PutMapping("/{id}")
	//@RolesAllowed("Admin")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	//@RolesAllowed("Admin")
	public void deleteBook(@PathVariable Integer id) {
		bookService.deleteBookById(id);
	}

}
