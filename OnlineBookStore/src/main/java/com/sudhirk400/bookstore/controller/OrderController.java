/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	

	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders(); 
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Integer id) {
		return orderService.getOrderById(id);
	}	
	
	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}

	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable Integer id) {
		orderService.deleteOrderById(id);
	}

}
