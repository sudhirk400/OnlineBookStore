/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

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
	@RolesAllowed("Admin")
	public List<BookRecord> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("{id}")
	//@RolesAllowed({"Admin","Customer"})
	@RolesAllowed("Admin")
	public BookRecord getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("create")
	@RolesAllowed("Admin")
	public BookRecord addBook(@Valid @RequestBody Book book) {
		BookRecord bookRecord = bookService.addBook(book);
		
		return bookRecord;
	}	


	@PutMapping("update")
	@RolesAllowed("Admin")
	public BookRecord updateBook(@Valid @RequestBody Book book) {
		BookRecord bookRecord = bookService.updateBook(book);
		
		return bookRecord;
	}

	@DeleteMapping("delete/{id}")
	@RolesAllowed("Admin")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBookById(id);
		return "Book is deleted successfully!";
	}
	
	
	/**
	 * Gets the book by title.
	 *
	 * @param title the title
	 * @return the book by title
	 */
	@GetMapping("getByTitle/{title}")
	@RolesAllowed("Customer")
	public List<BookRecord> getBookByTitle(@PathVariable String title) 
	{
		return bookService.getBookByTitle(title);
	}
	
	@GetMapping("getByTitleAndCondition/{title}/{genre}")
	@RolesAllowed("Customer")
	public BookRecord getBookByTitle(@PathVariable String title, @PathVariable String genre) 
	{
		return bookService.getBookByTitleAndGenre(title, genre);
	}	

}
