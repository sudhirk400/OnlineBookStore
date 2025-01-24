package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @EmbeddedId
    private OrderItemKey id; // Composite primary key

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;


}

