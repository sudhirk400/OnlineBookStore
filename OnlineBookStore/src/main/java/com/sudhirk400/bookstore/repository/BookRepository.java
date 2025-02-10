package com.sudhirk400.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhirk400.bookstore.model.Book;
import java.util.List;

/**
 * The Interface BookRepository.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
	/**
	 * Find by title containing ignore case.
	 *
	 * @param title the title
	 * @return the list
	 */
	List<Book> findByTitleContainingIgnoreCase(String title);

	/**
	 * Find by genre containing ignore case.
	 *
	 * @param genre the genre
	 * @return the list
	 */
	List<Book> findByGenreContainingIgnoreCase(String genre);

	/**
	 * Find by price between.
	 *
	 * @param minPrice the min price
	 * @param maxPrice the max price
	 * @return the list
	 */
	List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
}
