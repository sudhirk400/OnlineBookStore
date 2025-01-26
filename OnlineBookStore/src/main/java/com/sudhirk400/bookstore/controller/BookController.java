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

import com.sudhirk400.bookstore.dto.BookRecord;
import com.sudhirk400.bookstore.model.Book;
import com.sudhirk400.bookstore.service.BookService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

//import jakarta.annotation.security.RolesAllowed;

/**
 * 
 */
@RestController
@RequestMapping("/api/book/")
public class BookController {

	private final BookService bookService;

	//@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("getAll")
	@RolesAllowed({"Admin","Customer"})
	public List<BookRecord> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("{id}")
	@RolesAllowed({"Admin","Customer"})
	//@RolesAllowed("Customer")
	public BookRecord getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("create")
	public BookRecord addBook(@Valid @RequestBody Book book) {
		BookRecord bookRecord = bookService.addBook(book);
		
		return bookRecord;
	}	


	@PutMapping("update")
	//@RolesAllowed("Admin")
	public BookRecord updateBook(@Valid @RequestBody Book book) {
		BookRecord bookRecord = bookService.updateBook(book);
		
		return bookRecord;
	}

	@DeleteMapping("delete/{id}")
	//@RolesAllowed("Admin")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return "Book is deleted successfully!";
	}

}
