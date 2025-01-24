package com.sudhirk400.bookstore.dto;

public record BookRecord(
	    String isbn,
	    String title,
	    String author,
	    String genre,
	    double price,
	    int stockQuantity
	) {}