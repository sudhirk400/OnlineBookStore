package com.sudhirk400.bookstore.dto;

import java.math.BigDecimal;

import com.sudhirk400.bookstore.model.Book;

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
		String condition
		
	) {
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
	            book.getCondition()
	        );
	    }	
}