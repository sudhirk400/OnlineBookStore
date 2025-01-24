/**
 * 
 */
package com.sudhirk400.bookstore.dto;

import java.util.List;

/**
 * 
 */
public record CartRecord(
	    List<CartItemRecord> items,
	    double totalPrice		
		) { }
