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
 * 
 */
@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

	private final CustomerService  customerService;

 
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("getAll")
	//@RolesAllowed("Admin")
	public List<CustomerRecord> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("{id}")
	//@RolesAllowed("Admin")
	public CustomerRecord getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("create")
	//@RolesAllowed("Admin")
	public CustomerRecord addCustomer(@Valid @RequestBody Customer customer) {
		CustomerRecord customerRecord = customerService.addCustomer(customer);
		
		return customerRecord;
	}	


	@PutMapping("update")
	//@RolesAllowed("Admin")
	public CustomerRecord updateCustomer(@Valid @RequestBody Customer customer) {
		CustomerRecord customerRecord = customerService.updateCustomer(customer);
		
		return customerRecord;
	}

	
	
	
	@DeleteMapping("delete/{id}")
	//@RolesAllowed("Admin")
	public String deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomerById(id);
		return "Customer is deleted successfully!";
	}

}
