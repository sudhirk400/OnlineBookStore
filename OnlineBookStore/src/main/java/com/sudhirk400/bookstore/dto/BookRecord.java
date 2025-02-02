package com.sudhirk400.bookstore.dto;

import java.math.BigDecimal;

import com.sudhirk400.bookstore.model.Book;

 
 
 
/**
 * The Record BookRecord.
 *
 * @param bookID the book ID
 * @param authorID the author ID
 * @param publisherID the publisher ID
 * @param title the title
 * @param isbn the isbn
 * @param genre the genre
 * @param type the type
 * @param publicationYear the publication year
 * @param price the price
 * @param quantity the quantity
 */
 
public record BookRecord(
		Integer bookID,
		Integer authorID,
		Integer publisherID,
		String title,
		String isbn,
		String genre,
		String type,
		Integer publicationYear,
		BigDecimal price,
		Integer quantity
		
	) {
	
	/**
	 * Instantiates a new book record.
	 *
	 * @param book the book
	 */
	//constructor that maps from a Books entity
	 public BookRecord(Book book) {
	        this(
	            book.getBookID(),
	            book.getAuthorID(),
	            book.getPublisherID(),
	            book.getTitle(),
	            book.getIsbn(),
	            book.getGenre(),
	            book.getType(),
	            book.getPublicationYear(),
	            book.getPrice(),
	            book.getQuantity()
	        );
	    }	
	 
	    /**
    	 * Gets the book ID.
    	 *
    	 * @return the book ID
    	 */
    	public Integer getBookID() {
	        return bookID;
	    }	
    	
    	/**
	     * Gets the price.
	     *
	     * @return the price
	     */
	    public BigDecimal getPrice() {
			return price;

		}
}