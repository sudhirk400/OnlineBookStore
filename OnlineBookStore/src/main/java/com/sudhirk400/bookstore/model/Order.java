package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

 
/**
 * The Class Order.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    /** The Order ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment is enabled for orderID
    @Column(name = "orderID", nullable = false)
    private Integer OrderID;

    /** The customer ID. */
    @Column(name = "customerID", nullable = false)
    private Integer customerID;

    /** The order date. */
    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    /** The subtotal. */
    @Column(name = "Subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    /** The shipping. */
    @Column(name = "Shipping", precision = 10, scale = 2, nullable = false)
    private BigDecimal shipping;

    /** The total. */
    @Column(name = "Total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;


}

