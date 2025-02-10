package com.sudhirk400.bookstore.dto;

import com.sudhirk400.bookstore.model.Customer;

/**
 * The Record CustomerRecord.
 *
 * @param customerID the customer ID
 * @param name the name
 * @param email the email
 * @param streetNumber the street number
 * @param streetName the street name
 * @param postalCode the postal code
 * @param state the state
 * @param country the country
 * @param phoneNumber the phone number
 */
public record CustomerRecord(Integer customerID, String name, String email,
		Integer streetNumber, String streetName, String postalCode,
		String state, String country, String phoneNumber

) {

	/**
	 * Instantiates a new customer record.
	 *
	 * @param customer
	 *            the customer
	 */
	// constructor that maps from a Customer entity
	public CustomerRecord(Customer customer) {
		this(customer.getCustomerID(), customer.getName(), customer.getEmail(),
				customer.getStreetNumber(), customer.getStreetName(),
				customer.getPostalCode(), customer.getState(),
				customer.getCountry(), customer.getPhoneNumber());
	}
}