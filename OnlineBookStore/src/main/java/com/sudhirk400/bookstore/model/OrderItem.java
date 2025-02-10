package com.sudhirk400.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class OrderItem.
 */
@Data
@Entity
@Table(name = "order_item")
public class OrderItem {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id", nullable = false)
	private Long id;

	/** The order. */
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	/** The book. */
	@OneToOne
	@JoinColumn(name = "book_id")
	private Book book;

	/** The quantity. */
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

}
