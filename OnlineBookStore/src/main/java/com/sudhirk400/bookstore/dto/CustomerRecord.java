package com.sudhirk400.bookstore.dto;

import com.sudhirk400.bookstore.model.Customer;

 

public record CustomerRecord(
		Integer customerID,
		String firstName,
		String lastName,
		Integer streetNumber,
		String streetName,
		String postalCode,
		String state,
		String country,
		String phoneNumber
				
		
	) {
	
	/**
	 * Instantiates a new customer record.
	 *
	 * @param customer the customer
	 */
	//constructor that maps from a Customer entity
	 public CustomerRecord(Customer customer) {
	        this(
        		customer.getCustomerID(),
        		customer.getFirstName(),
        		customer.getLastName(),
        		customer.getStreetNumber(),
        		customer.getStreetName(),
        		customer.getPostalCode(),
        		customer.getState(),
        		customer.getCountry(),
        		customer.getPhoneNumber() 
	        );
	    }	
}