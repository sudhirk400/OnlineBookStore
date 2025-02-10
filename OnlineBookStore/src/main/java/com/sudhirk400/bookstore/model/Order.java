package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * The Class Order.
 */
@Data
@Entity
@Table(name = "order")
public class Order {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private Long id;

	/** The customer. */
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/** The order items. */
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems;

	/** The order date. */
	@Column(name = "order_date", nullable = false)
	private Date orderDate;

	/** The status. */
	@Column(name = "status", nullable = false)
	private String status;

	/** The total. */
	@Column(name = "total", precision = 10, scale = 2, nullable = false)
	private BigDecimal total;

}
