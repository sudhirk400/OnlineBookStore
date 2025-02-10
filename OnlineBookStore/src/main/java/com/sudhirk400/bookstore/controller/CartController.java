package com.sudhirk400.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sudhirk400.bookstore.model.Cart;
import com.sudhirk400.bookstore.service.CartService;

/**
 * The Class CartController.
 */
@RestController
@RequestMapping("/api/carts")
public class CartController {

	/** The cart service. */
	@Autowired
	private CartService cartService;

	/**
	 * Adds the to cart.
	 *
	 * @param email the email
	 * @param bookId the book id
	 * @param quantity the quantity
	 * @return the cart
	 */
	@PostMapping
	public Cart addToCart(@RequestParam String email, @RequestParam Long bookId,
			@RequestParam Integer quantity) {
		Cart cart = cartService.addToCart(email, bookId, quantity);
		return cart;
	}

	/**
	 * View cart.
	 *
	 * @param email the email
	 * @return the cart
	 */
	@GetMapping
	public Cart viewCart(@RequestParam String email) {
		Cart cart = cartService.viewCart(email);
		return cart;
	}

	/**
	 * Update cart item.
	 *
	 * @param cartItemId the cart item id
	 * @param quantity the quantity
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<Void> updateCartItem(@RequestParam Long cartItemId,
			@RequestParam Integer quantity) {
		cartService.updateCartItem(cartItemId, quantity);
		return ResponseEntity.ok().build();
	}

	/**
	 * Removes the cart item.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
		cartService.removeCartItem(id);
		return ResponseEntity.ok().build();
	}

	/**
	 * Checkout.
	 *
	 * @param email the email
	 * @return the response entity
	 */
	@PostMapping("/checkout")
	public ResponseEntity<Void> checkout(@RequestParam String email) {
		cartService.checkout(email);
		return ResponseEntity.ok().build();
	}
}