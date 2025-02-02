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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Author")
public class Author {

    /** The author ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment for AuthorID
    @Column(name = "AuthorID", nullable = false)
    private Integer authorID;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "bookID", nullable = false, insertable = false, updatable = false)
    private Integer bookID;

    @ManyToOne
    @JoinColumn(name = "bookID", referencedColumnName = "bookID")
    private Book book;

}
