/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhirk400.bookstore.model.Order;
import com.sudhirk400.bookstore.service.OrderService;

/**
 * 
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
	}

	@GetMapping("/{userId}")
	public List<Order> getOrderHistory(@PathVariable Long userId) {
		return orderService.getOrderHistory(userId);
	}
}
