/**
 * 
 */
package com.sudhirk400.bookstore.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.dto.BookRecord;
import com.sudhirk400.bookstore.model.Author;
import com.sudhirk400.bookstore.model.Book;
import com.sudhirk400.bookstore.model.Publisher;
import com.sudhirk400.bookstore.repository.AuthorRepository;
import com.sudhirk400.bookstore.repository.BookRepository;
import com.sudhirk400.bookstore.repository.PublisherRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * The Class BookService.
 */
@Service
public class BookService {

	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;

	/** The author repository. */
	@Autowired
	private AuthorRepository authorRepository;

	/** The publisher repository. */
	@Autowired
	private PublisherRepository publisherRepository;

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	public List<BookRecord> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(book -> new BookRecord(book))
				.collect(Collectors.toList());
	}

	/**
	 * Gets the book by id.
	 *
	 * @param id
	 *            the id
	 * @return the book by id
	 */
	public BookRecord getBookById(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found"));
		return new BookRecord(book);
	}

	/**
	 * Adds the book.
	 *
	 * @param book
	 *            the book
	 * @return the book record
	 */
	public BookRecord addBook(Book book) {
		Author author = authorRepository.findById(book.getAuthorID())
				.orElseThrow();
		Publisher publisher = publisherRepository
				.findById(book.getPublisherID()).orElseThrow();
		book.setAuthor(author);
		book.setPublisher(publisher);
		Book addedBook = bookRepository.save(book);
		return new BookRecord(addedBook);
	}

	/**
	 * Update book.
	 *
	 * @param bookId the book id
	 * @param bookToUpdate            the book to update
	 * @return the book record
	 * @throws EntityNotFoundException the entity not found exception
	 */
	// Update an existing book
	public BookRecord updateBook(Long bookId, Book bookToUpdate)
			throws EntityNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new EntityNotFoundException(
						"Book not found with ID: " + bookId));

		Optional.ofNullable(bookToUpdate.getTitle())
				.filter(title -> !title.isEmpty()).ifPresent(book::setTitle);
		Optional.ofNullable(bookToUpdate.getIsbn())
				.filter(isbn -> !isbn.isEmpty()).ifPresent(book::setIsbn);
		Optional.ofNullable(bookToUpdate.getGenre())
				.filter(genre -> !genre.isEmpty()).ifPresent(book::setGenre);
		Optional.ofNullable(bookToUpdate.getType())
				.filter(type -> !type.isEmpty()).ifPresent(book::setType);
		Optional.ofNullable(bookToUpdate.getPublicationYear())
				.filter(year -> year > 0).ifPresent(book::setPublicationYear);
		Optional.ofNullable(bookToUpdate.getPrice())
				.filter(price -> price.compareTo(BigDecimal.ZERO) > 0)
				.ifPresent(book::setPrice);
		Optional.ofNullable(bookToUpdate.getQuantity()).filter(qty -> qty > 0)
				.ifPresent(book::setQuantity);
		Optional.ofNullable(bookToUpdate.getAuthor())
				.ifPresent(book::setAuthor);
		Optional.ofNullable(bookToUpdate.getPublisher())
				.ifPresent(book::setPublisher);

		return new BookRecord(bookRepository.save(book));
	}

	/**
	 * Delete book by id.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
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
	public List<BookRecord> searchBooks(String title, String genre,
			Double minPrice, Double maxPrice) {

		if (title != null)
			return covertToRecord(
					bookRepository.findByTitleContainingIgnoreCase(title));
		if (genre != null)
			return covertToRecord(
					bookRepository.findByGenreContainingIgnoreCase(genre));
		if (minPrice != null && maxPrice != null)
			return covertToRecord(
					bookRepository.findByPriceBetween(minPrice, maxPrice));
		return covertToRecord(bookRepository.findAll());

	}

	/**
	 * Covert to record.
	 *
	 * @param books the books
	 * @return the list
	 */
	private List<BookRecord> covertToRecord(List<Book> books) {
		return books.stream().map(book -> new BookRecord(book))
				.collect(Collectors.toList());
	}

}
