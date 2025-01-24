/**
 * 
 */
package com.sudhirk400.bookstore.dto;

import java.util.List;

/**
 * 
 */
public record OrderRecord(
	    Long orderId,
	    Long userId,
	    List<CartItemRecord> orderedItems,
	    double totalAmount,
	    String orderStatus,
	    String orderDate		
		) {}
