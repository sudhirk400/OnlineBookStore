/**
 * 
 */
package com.sudhirk400.bookstore.model;

import java.util.List;

/**
 * 
 */
public record Cart(
	    List<CartItem> items,
	    double totalPrice		
		) { }
