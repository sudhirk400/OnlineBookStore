package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment for customerID
    @Column(name = "customerID", nullable = false, insertable = false, updatable = false)
    private Integer customerID;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "streetNumber", nullable = false)
    private Integer streetNumber;

    @Column(name = "streetName", nullable = false)
    private String streetName;

    @Column(name = "postalCode", nullable = false)
    private String postalCode;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "Country", nullable = false)
    private String country;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;


}

