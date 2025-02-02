package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByTitle(String title);
	
	/**
	 * Find by title and genre.
	 *
	 * @param title the title
	 * @param genre the genre
	 * @return the book
	 */
	Book findByTitleAndGenre(String title, String genre);
}
