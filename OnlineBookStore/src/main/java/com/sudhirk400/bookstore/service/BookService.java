/**
 * 
 */
package com.sudhirk400.bookstore.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.model.Book;
import com.sudhirk400.bookstore.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
    
    // Update an existing book
    public Book updateBook(Integer bookID, Book updatedBook) {
        Optional<Book> existingBookOptional = bookRepository.findById(bookID);

        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();

            // Update fields
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setType(updatedBook.getType());
            existingBook.setPublicationYear(updatedBook.getPublicationYear());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setCondition(updatedBook.getCondition());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublisher(updatedBook.getPublisher());

            // Save updated book
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book with ID " + bookID + " not found");
        }
    }
}

