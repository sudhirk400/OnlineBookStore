/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhirk400.bookstore.model.Cart;
import com.sudhirk400.bookstore.model.CartItem;
import com.sudhirk400.bookstore.service.CartService;

/**
 * 
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Cart getCart() {
        return cartService.getCart();
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestBody CartItem cartItem) {
        return cartService.addToCart(cartItem);
    }

    @PostMapping("/remove")
    public Cart removeFromCart(@RequestBody CartItem cartItem) {
        return cartService.removeFromCart(cartItem);
    }

    @PostMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }
}
