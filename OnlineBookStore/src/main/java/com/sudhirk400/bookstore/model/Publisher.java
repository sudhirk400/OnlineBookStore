package com.sudhirk400.bookstore.model;

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

 
/**
 * The Class Publisher.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Publisher")
public class Publisher {

    /** The publisher ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment for publisherID
    @Column(name = "publisherID", nullable = false)
    private Integer publisherID;

    /** The country. */
    @Column(name = "Country", nullable = false)
    private String country;

    /** The book ID. */
    @Column(name = "bookID", nullable = false, insertable = false, updatable = false)
    private Integer bookID;

    /** The book. */
    @ManyToOne
    @JoinColumn(name = "bookID", referencedColumnName = "bookID")
    private Book book;
 
}


 

