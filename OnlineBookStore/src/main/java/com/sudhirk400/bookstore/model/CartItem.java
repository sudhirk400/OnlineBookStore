package com.sudhirk400.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Class CartItem.
 */
@Data
@Entity
@Table(name = "cart_items")
public class CartItem {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id", nullable = false)
	private Long cartItemId;

	/** The book. */
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	@JsonIgnore
	private Book book;

	/** The cart. */
	@ManyToOne
	@JoinColumn(name = "cart_id")
	@JsonIgnore
	private Cart cart;

	/** The quantity. */
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

}
