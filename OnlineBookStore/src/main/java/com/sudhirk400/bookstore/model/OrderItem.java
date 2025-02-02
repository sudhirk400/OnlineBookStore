package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

 
/**
 * The Class OrderItem.
 */
@Setter
@Getter
@Entity
@Table(name = "OrderItem")
public class OrderItem {

    /** The id. */
    @EmbeddedId
    private OrderItemKey id; // Composite primary key

    /** The quantity. */
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    /** The price. */
    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;


}

