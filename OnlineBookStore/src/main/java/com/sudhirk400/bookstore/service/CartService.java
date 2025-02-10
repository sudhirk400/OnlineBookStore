package com.sudhirk400.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudhirk400.bookstore.model.Book;
import com.sudhirk400.bookstore.model.Cart;
import com.sudhirk400.bookstore.model.CartItem;
import com.sudhirk400.bookstore.model.Customer;
import com.sudhirk400.bookstore.repository.BookRepository;
import com.sudhirk400.bookstore.repository.CartItemRepository;
import com.sudhirk400.bookstore.repository.CartRepository;
import com.sudhirk400.bookstore.repository.CustomerRepository;

import java.util.Optional;

/**
 * The Class CartService.
 */
@Service
public class CartService {

	/** The cart repository. */
	@Autowired
	private CartRepository cartRepository;

	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;

	/** The cart item repository. */
	@Autowired
	private CartItemRepository cartItemRepository;

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Adds the to cart.
	 *
	 * @param email
	 *            the email
	 * @param bookId
	 *            the book id
	 * @param quantity
	 *            the quantity
	 * @return the cart
	 */
	@Transactional
	public Cart addToCart(String email, Long bookId, Integer quantity) {
		Customer customer = customerRepository.findByEmail(email);
		Cart cart = cartRepository.findByCustomerEmail(email);
		if (cart == null) {
			cart = new Cart();
			cart.setCustomer(customer);
		}

		Optional<Book> bookOpt = bookRepository.findById(bookId);
		if (bookOpt.isPresent()) {
			Book book = bookOpt.get();
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setQuantity(quantity);
			cartItem.setCart(cart);
			cart.getCartItems().add(cartItem);
		}

		return cartRepository.save(cart);
	}

	/**
	 * View cart.
	 *
	 * @param email
	 *            the email
	 * @return the cart
	 */
	public Cart viewCart(String email) {
		return cartRepository.findByCustomerEmail(email);
	}

	/**
	 * Update cart item.
	 *
	 * @param cartItemId
	 *            the cart item id
	 * @param quantity
	 *            the quantity
	 */
	@Transactional
	public void updateCartItem(Long cartItemId, Integer quantity) {
		Optional<CartItem> cartItemOpt = cartItemRepository
				.findById(cartItemId);
		cartItemOpt.ifPresent(cartItem -> {
			cartItem.setQuantity(quantity);
			cartItemRepository.save(cartItem);
		});
	}

	/**
	 * Removes the cart item.
	 *
	 * @param cartItemId
	 *            the cart item id
	 */
	@Transactional
	public void removeCartItem(Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}

	/**
	 * Checkout.
	 *
	 * @param email
	 *            the email
	 */
	@Transactional
	public void checkout(String email) {
		Cart cart = cartRepository.findByCustomerEmail(email);
		if (cart != null && !cart.getCartItems().isEmpty()) {
			// Implement order creation and payment processing here
			cart.getCartItems().clear();
			cartRepository.save(cart);
		}
	}
}