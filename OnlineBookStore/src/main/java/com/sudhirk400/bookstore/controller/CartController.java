package com.sudhirk400.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sudhirk400.bookstore.dto.BookRecord;
import com.sudhirk400.bookstore.model.Cart;
import com.sudhirk400.bookstore.service.BookService;
import com.sudhirk400.bookstore.service.OrderService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
	
	private final OrderService orderService;
	
	private final BookService bookService;
	
	public CartController() {
		this.orderService = new OrderService();
		this.bookService = new BookService();
		
		// TODO Auto-generated constructor stub
	}


    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @PostMapping("/add/{bookID}")
    public String addToCart(@PathVariable int bookID, @RequestParam int quantity, 
                            @ModelAttribute("cart") Cart cart) {
        BookRecord book = bookService.getBookById(bookID); // Simulate fetching from DB
        if (book != null) {
            cart.addItem(book, quantity);
        }
        return "Book added to cart";
    }

    @GetMapping
    public Cart viewCart(@ModelAttribute("cart") Cart cart) {
        return cart;
    }

 
    
    @PostMapping("/checkout")
    public String  checkout(@ModelAttribute("cart") Cart cart, 
                                           @RequestParam int customerID, 
                                           HttpSession session) {
        try {
            orderService.createOrderFromCart(cart, customerID);
            session.removeAttribute("cart"); // Clear cart after checkout
            return "Order placed successfully!";
        } catch (RuntimeException e) {
            return  e.getMessage() ;
        }
    }    
}
