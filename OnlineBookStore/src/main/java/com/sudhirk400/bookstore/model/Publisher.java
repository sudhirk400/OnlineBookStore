package com.sudhirk400.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Class Publisher.
 */
@Data
@Entity
@Table(name = "publisher")
public class Publisher {

	/** The publisher ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id", nullable = false)
	private Integer publisherID;

	/** The country. */
	@Column(name = "name", nullable = false)
	private String name;

	/** The biography. */
	@Column(name = "biography", nullable = true)
	private String biography;

	/** The country. */
	@Column(name = "country", nullable = false)
	private String country;

}
