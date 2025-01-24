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
@Table(name = "Publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment for publisherID
    @Column(name = "publisherID", nullable = false)
    private Integer publisherID;

    @Column(name = "Country", nullable = false)
    private String country;

    @Column(name = "bookID", nullable = false, insertable = false, updatable = false)
    private Integer bookID;

    @ManyToOne
    @JoinColumn(name = "bookID", referencedColumnName = "bookID")
    private Book book;
 
}


 

