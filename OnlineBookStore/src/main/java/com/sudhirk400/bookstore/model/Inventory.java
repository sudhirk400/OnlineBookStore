package com.sudhirk400.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
/**
 * The Class Inventory.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {

    /** The book ID. */
    @Id
    @Column(name = "bookID", nullable = false)
    private Integer bookID;

    /** The stock level used. */
    @Column(name = "stockLevelUsed", nullable = true)
    private Integer stockLevelUsed;

    /** The stock level new. */
    @Column(name = "stockLevelNew", nullable = true)
    private Integer stockLevelNew;
 
}

