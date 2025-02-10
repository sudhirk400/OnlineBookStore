package com.sudhirk400.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * The Class Book.
 */
@Data
@Entity
@Table(name = "books")
public class Book {

	/** The book ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false)
	private Integer bookID;

	/** The author ID. */
	@Column(name = "author_id", nullable = false, insertable = false, updatable = false)
	private Integer authorID;

	/** The author. */
	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "author_id")
	@JsonIgnore
	private Author author;

	/** The publisher ID. */
	@Column(name = "publisher_id", nullable = false, insertable = false, updatable = false)
	private Integer publisherID;

	/** The publisher. */
	@ManyToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
	@JsonIgnore
	private Publisher publisher;

	/** The title. */
	@Column(name = "title", nullable = false)
	private String title;

	/** The isbn. */
	@Column(name = "isbn", nullable = false, unique = true)
	private String isbn;

	/** The genre. */
	@Column(name = "genre", nullable = false)
	private String genre;

	/** The type. */
	@Column(name = "type", nullable = false)
	private String type;

	/** The publication year. */
	@Column(name = "publisher_year", nullable = false)
	private Integer publicationYear;

	/** The price. */
	@Column(name = "price", nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	/** The quantity. */
	@Column(name = "quantity", nullable = true)
	private Integer quantity;
}
