package com.sudhirk400.bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
/**
 * The Class Customer.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {

    /** The customer ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assumes auto-increment for customerID
    @Column(name = "customerID", nullable = false, insertable = false, updatable = false)
    private Integer customerID;

    /** The first name. */
    @Column(name = "firstName", nullable = false)
    private String firstName;

    /** The last name. */
    @Column(name = "lastName", nullable = false)
    private String lastName;

    /** The street number. */
    @Column(name = "streetNumber", nullable = false)
    private Integer streetNumber;

    /** The street name. */
    @Column(name = "streetName", nullable = false)
    private String streetName;

    /** The postal code. */
    @Column(name = "postalCode", nullable = false)
    private String postalCode;

    /** The state. */
    @Column(name = "State", nullable = false)
    private String state;

    /** The country. */
    @Column(name = "Country", nullable = false)
    private String country;

    /** The phone number. */
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;


}

