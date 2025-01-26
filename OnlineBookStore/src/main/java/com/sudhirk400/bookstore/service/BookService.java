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
	public BookRecord updateBook(Book updatedBook) {
		Book book = bookRepository.findById(updatedBook.getBookID()).get();
		// Update fields
		if (updatedBook.getTitle() != null && 
				!updatedBook.getTitle().isEmpty()) {
			book.setTitle(updatedBook.getTitle());
		}
		if (updatedBook.getIsbn() != null && 
				!updatedBook.getIsbn().isEmpty()) {
			book.setIsbn(updatedBook.getIsbn());
		}
		if (updatedBook.getGenre() != null && 
				!updatedBook.getGenre().isEmpty()) {
			book.setGenre(updatedBook.getGenre());
		}
		 
		if (updatedBook.getType() != null && 
				!updatedBook.getType().isEmpty()) {
			book.setType(updatedBook.getType());
		}	
		
		
		if (updatedBook.getPublicationYear() != null && 
				(updatedBook.getPublicationYear().intValue() > 0) ) {
			book.setPublicationYear(updatedBook.getPublicationYear());
		}
		if (updatedBook.getPrice() != null && 
				(updatedBook.getPrice().intValue() > 0)) {
			book.setPrice(updatedBook.getPrice());
		}
		if (updatedBook.getCondition() != null && 
				!updatedBook.getCondition().isEmpty()) {
			book.setCondition(updatedBook.getCondition());
		}
		if (updatedBook.getAuthor() != null ) {
			book.setAuthor(updatedBook.getAuthor());
		}
		if (updatedBook.getPublisher() != null ) {
			book.setPublisher(updatedBook.getPublisher());
		}		
		// Save updated book
		Book modBook =  bookRepository.save(book);
		return new BookRecord(modBook);
	}
	
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
    

}

