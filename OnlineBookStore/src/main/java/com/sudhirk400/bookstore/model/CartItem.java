package com.sudhirk400.bookstore.model;

import com.sudhirk400.bookstore.dto.BookRecord;


 
/**
 * The Class CartItem.
 */
public class CartItem {

    /** The book. */
    private BookRecord book;
    
    /** The quantity. */
    private int quantity;

    /**
     * Instantiates a new cart item.
     *
     * @param book the book
     * @param quantity the quantity
     */
    public CartItem(BookRecord book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public BookRecord getBook() {
        return book;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

