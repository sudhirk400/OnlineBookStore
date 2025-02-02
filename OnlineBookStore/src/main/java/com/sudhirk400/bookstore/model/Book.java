package com.sudhirk400.bookstore.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book")
public class Book {

    /** The book ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment for bookID
    @Column(name = "bookID", nullable = false, insertable = false, updatable = false)
    private Integer bookID;
    

    @Column(name = "AuthorID", nullable = false, insertable = false, updatable = false)
    private Integer authorID;

    @ManyToOne
    @JoinColumn(name = "AuthorID", referencedColumnName = "AuthorID")
    @JsonIgnore
    private Author author;

    @Column(name = "PublisherID", nullable = false, insertable = false, updatable = false)
    private Integer publisherID;

    @ManyToOne
    @JoinColumn(name = "PublisherID", referencedColumnName = "publisherID")
    @JsonIgnore
    private Publisher publisher;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "ISBN", nullable = false, unique = true)
    private String isbn;

    @Column(name = "Genre", nullable = false)
    private String genre;

    @Column(name = "Type", nullable = false)
    private String type;

    @Column(name = "PublicationYear", nullable = false)
    private Integer publicationYear;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "Quantity", nullable = true)
    private Integer quantity;
}

 