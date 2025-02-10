/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudhirk400.bookstore.dto.BookRecord;
import com.sudhirk400.bookstore.model.Book;
import com.sudhirk400.bookstore.service.BookService;

 

/**
 * The Class BookController.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

	/** The book service. */
	private final BookService bookService;

	/**
	 * Instantiates a new book controller.
	 *
	 * @param bookService the book service
	 */
	// @Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	@GetMapping
	public List<BookRecord> getAllBooks() {
		return bookService.getAllBooks();
	}

	/**
	 * Gets the book by id.
	 *
	 * @param id the id
	 * @return the book by id
	 */
	@GetMapping("/{id}")
	public BookRecord getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	/**
	 * Adds the book.
	 *
	 * @param book the book
	 * @return the book record
	 */
	@PreAuthorize("hasRole('Admin')")
	@PostMapping
	public BookRecord addBook(@RequestBody Book book) {
		BookRecord bookRecord = bookService.addBook(book);

		return bookRecord;
	}

	/**
	 * Update book.
	 *
	 * @param id the id
	 * @param book the book
	 * @return the book record
	 */
	@PreAuthorize("hasRole('Admin')")
	@PutMapping("/{id}")
	public BookRecord updateBook(@PathVariable Long id,
			@RequestBody Book book) {
		BookRecord bookRecord = bookService.updateBook(id, book);

		return bookRecord;
	}

	/**
	 * Delete book.
	 *
	 * @param id the id
	 * @return the string
	 */
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBookById(id);
		return "Book is deleted successfully!";
	}

	/**
	 * Search books.
	 *
	 * @param title the title
	 * @param genre the genre
	 * @param minPrice the min price
	 * @param maxPrice the max price
	 * @return the list
	 */
	@GetMapping("/search")
	public List<BookRecord> searchBooks(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String genre,
			@RequestParam(required = false) Double minPrice,
			@RequestParam(required = false) Double maxPrice) {
		return bookService.searchBooks(title, genre, minPrice, maxPrice);
	}

}
