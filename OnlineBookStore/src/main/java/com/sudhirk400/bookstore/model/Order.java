/**
 * 
 */
package com.sudhirk400.bookstore.model;

import java.util.List;

/**
 * 
 */
public record Order(
	    Long orderId,
	    Long userId,
	    List<CartItem> orderedItems,
	    double totalAmount,
	    String orderStatus,
	    String orderDate		
		) {}
