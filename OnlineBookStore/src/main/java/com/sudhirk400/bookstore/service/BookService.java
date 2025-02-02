/**
 * 
 */
package com.sudhirk400.bookstore.service;
import java.util.List;
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
        return books.stream()
                .map(book -> new BookRecord(book)).collect(Collectors.toList());
    }

    /**
     * Gets the book by id.
     *
     * @param id the id
     * @return the book by id
     */
    public BookRecord getBookById(Integer id) {
    	Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    	return new BookRecord(book);
    }

    /**
     * Adds the book.
     *
     * @param book the book
     * @return the book record
     */
    public BookRecord addBook(Book book) {
    	
    	Author author = authorRepository.findById(book.getAuthorID()).orElseThrow();
    	Publisher publisher = publisherRepository.findById(book.getPublisherID()).orElseThrow();
    	book.setAuthor(author);
    	book.setPublisher(publisher);    	
    	Book addedBook =  bookRepository.save(book);
    	return new BookRecord(addedBook);
    }

	/**
	 * Update book.
	 *
	 * @param bookToUpdate the book to update
	 * @return the book record
	 */
	// Update an existing book
	public BookRecord updateBook(Book bookToUpdate) {
		Book book = bookRepository.findById(bookToUpdate.getBookID()).get();
		// Update fields
		if (bookToUpdate.getTitle() != null && 
				!bookToUpdate.getTitle().isEmpty()) {
			book.setTitle(bookToUpdate.getTitle());
		}
		if (bookToUpdate.getIsbn() != null && 
				!bookToUpdate.getIsbn().isEmpty()) {
			book.setIsbn(bookToUpdate.getIsbn());
		}
		if (bookToUpdate.getGenre() != null && 
				!bookToUpdate.getGenre().isEmpty()) {
			book.setGenre(bookToUpdate.getGenre());
		}
		 
		if (bookToUpdate.getType() != null && 
				!bookToUpdate.getType().isEmpty()) {
			book.setType(bookToUpdate.getType());
		}	
		
		
		if (bookToUpdate.getPublicationYear() != null && 
				(bookToUpdate.getPublicationYear().intValue() > 0) ) {
			book.setPublicationYear(bookToUpdate.getPublicationYear());
		}
		if (bookToUpdate.getPrice() != null && 
				(bookToUpdate.getPrice().intValue() > 0)) {
			book.setPrice(bookToUpdate.getPrice());
		}
		if (bookToUpdate.getQuantity() != null && 
				(bookToUpdate.getQuantity().intValue() > 0)) {
			book.setQuantity(bookToUpdate.getQuantity());
		}
		if (bookToUpdate.getAuthor() != null ) {
			book.setAuthor(bookToUpdate.getAuthor());
		}
		if (bookToUpdate.getPublisher() != null ) {
			book.setPublisher(bookToUpdate.getPublisher());
		}		
		// Save updated book
		Book modBook =  bookRepository.save(book);
		return new BookRecord(modBook);
	}
	
    /**
     * Delete book by id.
     *
     * @param id the id
     */
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
    
    
    /**
     * Gets the book by title.
     *
     * @param title the title
     * @return the book by title
     */
    public List<BookRecord> getBookByTitle(String title)
    {
    	List<Book> books = bookRepository.findByTitle(title);
        return books.stream()
                .map(book -> new BookRecord(book)).collect(Collectors.toList());    	
    }

    /**
     * Gets the book by title and genre.
     *
     * @param title the title
     * @param genre the genre
     * @return the book by title and genre
     */
    public BookRecord getBookByTitleAndGenre(String title, String genre)
    {
    	Book book = bookRepository.findByTitleAndGenre(title, genre);
    	return  new BookRecord(book);
    }
    
    
    
}

