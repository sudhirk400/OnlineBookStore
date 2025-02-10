package com.sudhirk400.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Class Author.
 */
@Data
@Entity
@Table(name = "author")
public class Author {

	/** The author ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id", nullable = false)
	private Integer authorID;

	/** The name. */
	@Column(name = "name", nullable = false)
	private String name;

	/** The biography. */
	@Column(name = "biography", nullable = true)
	private String biography;

}
