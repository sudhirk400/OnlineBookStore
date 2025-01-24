package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment is enabled for orderID
    @Column(name = "orderID", nullable = false)
    private Integer OrderID;

    @Column(name = "customerID", nullable = false)
    private Integer customerID;

    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    @Column(name = "Subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "Shipping", precision = 10, scale = 2, nullable = false)
    private BigDecimal shipping;

    @Column(name = "Total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;


}

