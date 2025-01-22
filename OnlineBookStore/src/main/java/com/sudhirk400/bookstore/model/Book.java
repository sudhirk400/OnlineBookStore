package com.sudhirk400.bookstore.model;

public record Book(
	    String isbn,
	    String title,
	    String author,
	    String genre,
	    double price,
	    int stockQuantity
	) {}