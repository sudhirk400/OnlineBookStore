package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusID;

    @Column(unique = true, nullable = false)
    private String statusName;  // Example: Pending, Shipped, Delivered


}
