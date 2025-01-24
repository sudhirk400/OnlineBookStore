package com.sudhirk400.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "Inventory")
public class Inventory {

    @Id
    @Column(name = "bookID", nullable = false)
    private Integer bookID;

    @Column(name = "stockLevelUsed", nullable = true)
    private Integer stockLevelUsed;

    @Column(name = "stockLevelNew", nullable = true)
    private Integer stockLevelNew;
 
}

