package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;

    @OneToOne
    @JoinColumn(name = "orderID", nullable = false)
    private Order order;

    @Column(nullable = false)
    private String paymentMethod;  // Example: Credit Card, PayPal

    @Column(nullable = false)
    private String transactionID;  // Unique payment transaction identifier

    @Column(nullable = false)
    private boolean paymentStatus;  // true = success, false = failed

    private Date paymentDate;

    // Getters and Setters
}
