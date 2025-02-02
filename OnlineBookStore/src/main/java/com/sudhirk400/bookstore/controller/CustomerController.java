/**
 * 
 */
package com.sudhirk400.bookstore.controller;

import java.util.List;

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

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

 
//import jakarta.annotation.security.RolesAllowed;

/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

	/** The customer service. */
	private final CustomerService  customerService;

 
	/**
	 * Instantiates a new customer controller.
	 *
	 * @param customerService the customer service
	 */
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 */
	@GetMapping("getAll")
	@RolesAllowed("Admin")
	public List<CustomerRecord> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 */
	@GetMapping("{id}")
	@RolesAllowed("Admin")
	public CustomerRecord getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}
	
	/**
	 * Adds the customer.
	 *
	 * @param customer the customer
	 * @return the customer record
	 */
	@PostMapping("create")
	@RolesAllowed("Admin")
	public CustomerRecord addCustomer(@Valid @RequestBody Customer customer) {
		CustomerRecord customerRecord = customerService.addCustomer(customer);
		
		return customerRecord;
	}	


	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the customer record
	 */
	@PutMapping("update")
	@RolesAllowed("Admin")
	public CustomerRecord updateCustomer(@Valid @RequestBody Customer customer) {
		CustomerRecord customerRecord = customerService.updateCustomer(customer);
		
		return customerRecord;
	}

	
	
	
	/**
	 * Delete customer.
	 *
	 * @param id the id
	 * @return the string
	 */
	@DeleteMapping("delete/{id}")
	@RolesAllowed("Admin")
	public String deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomerById(id);
		return "Customer is deleted successfully!";
	}

}
