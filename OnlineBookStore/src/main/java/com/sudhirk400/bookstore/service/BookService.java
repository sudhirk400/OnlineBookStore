/**
 * 
 */
package com.sudhirk400.bookstore.service;
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

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private PublisherRepository publisherRepository;
    
    public List<BookRecord> getAllBooks() {
    	List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> new BookRecord(book)).collect(Collectors.toList());
    }

    public BookRecord getBookById(Integer id) {
    	Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    	return new BookRecord(book);
    }

    public BookRecord addBook(Book book) {
    	
    	Author author = authorRepository.findById(book.getAuthorID()).orElseThrow();
    	Publisher publisher = publisherRepository.findById(book.getPublisherID()).orElseThrow();
    	book.setAuthor(author);
    	book.setPublisher(publisher);    	
    	Book addedBook =  bookRepository.save(book);
    	return new BookRecord(addedBook);
    }

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
		if (bookToUpdate.getCondition() != null && 
				!bookToUpdate.getCondition().isEmpty()) {
			book.setCondition(bookToUpdate.getCondition());
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
	
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
    

}

