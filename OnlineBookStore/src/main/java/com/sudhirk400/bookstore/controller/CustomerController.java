/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhirk400.bookstore.dto.CustomerRecord;
import com.sudhirk400.bookstore.model.Customer;
import com.sudhirk400.bookstore.service.CustomerService;

import jakarta.validation.Valid;


/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	/** The customer service. */
	private final CustomerService customerService;

	/**
	 * Instantiates a new customer controller.
	 *
	 * @param customerService
	 *            the customer service
	 */
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 */
	@GetMapping
	public List<CustomerRecord> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	/**
	 * Adds the customer.
	 *
	 * @param customer the customer
	 * @return the customer record
	 */
	@PreAuthorize("hasRole('Customer')")
	@PostMapping
	public CustomerRecord addCustomer(@Valid @RequestBody Customer customer) {
		CustomerRecord customerRecord = customerService.addCustomer(customer);

		return customerRecord;
	}

	/**
	 * Update customer.
	 *
	 * @param customer
	 *            the customer
	 * @return the customer record
	 */
	@PreAuthorize("hasRole('Customer')")
	@PutMapping
	public CustomerRecord updateCustomer(
			@Valid @RequestBody Customer customer) {
		CustomerRecord customerRecord = customerService
				.updateCustomer(customer);

		return customerRecord;
	}

	/**
	 * Delete customer.
	 *
	 * @param id the id
	 * @return the string
	 */
	@PreAuthorize("hasRole('Customer')")
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomerById(id);
		return "Customer is deleted successfully!";
	}

}
