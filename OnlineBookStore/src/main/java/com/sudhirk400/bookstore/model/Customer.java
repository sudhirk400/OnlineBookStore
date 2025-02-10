package com.sudhirk400.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Customer.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	/** The customer ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes
														// auto-increment for
														// customerID
	@Column(name = "customer_id", nullable = false, insertable = false, updatable = false)
	private Integer customerID;

	/** The name. */
	@Column(name = "name", nullable = false)
	private String name;

	/** The email. */
	@Column(name = "email", nullable = false)
	private String email;

	/** The street number. */
	@Column(name = "streetNumber", nullable = false)
	private Integer streetNumber;

	/** The street name. */
	@Column(name = "streetName", nullable = false)
	private String streetName;

	/** The postal code. */
	@Column(name = "postalCode", nullable = false)
	private String postalCode;

	/** The state. */
	@Column(name = "State", nullable = false)
	private String state;

	/** The country. */
	@Column(name = "Country", nullable = false)
	private String country;

	/** The phone number. */
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

}
