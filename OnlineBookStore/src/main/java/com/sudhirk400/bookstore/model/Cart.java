package com.sudhirk400.bookstore.model;

import java.util.HashMap;
import java.util.Map;

import com.sudhirk400.bookstore.dto.BookRecord;

// TODO: Auto-generated Javadoc
/**
 * The Class Cart.
 */
public class Cart {

    /** The items. */
    private Map<Integer, CartItem> items = new HashMap<>(); // Key: bookID, Value: CartItem

    /**
     * Adds the item.
     *
     * @param book the book
     * @param quantity the quantity
     */
    public void addItem(BookRecord book, int quantity) {
        items.putIfAbsent(book.getBookID(), new CartItem(book, quantity));
    }

    /**
     * Update item.
     *
     * @param bookID the book ID
     * @param quantity the quantity
     */
    public void updateItem(int bookID, int quantity) {
        if (items.containsKey(bookID)) {
            items.get(bookID).setQuantity(quantity);
        }
    }

    /**
     * Removes the item.
     *
     * @param bookID the book ID
     */
    public void removeItem(int bookID) {
        items.remove(bookID);
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public Map<Integer, CartItem> getItems() {
        return items;
    }
}

