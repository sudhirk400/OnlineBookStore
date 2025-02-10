package com.sudhirk400.bookstore.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Class Payment.
 */
@Data
@Entity
@Table(name = "payment")
public class Payment {

	/** The payment ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", nullable = false)
	private Long paymentID;

	/** The order. */
	@OneToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	/** The payment method. */
	@Column(name = "payment_method", nullable = false)
	private String paymentMethod; // Example: Credit Card, PayPal

	/** The transaction ID. */
	@Column(name = "transaction_id", nullable = false)
	private String transactionID; // Unique payment transaction identifier

	/** The payment status. */
	@Column(name = "payment_status", nullable = false)
	private boolean paymentStatus; // true = success, false = failed

	/** The payment date. */
	@Column(name = "payment_date", nullable = false)
	private Date paymentDate;

}
