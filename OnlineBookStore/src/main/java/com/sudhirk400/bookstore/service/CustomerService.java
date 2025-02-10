package com.sudhirk400.bookstore.service;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhirk400.bookstore.dto.CustomerRecord;
import com.sudhirk400.bookstore.model.Customer;
import com.sudhirk400.bookstore.repository.CustomerRepository;

/**
 * The Class CustomerService.
 */
@Service
public class CustomerService {

	/** The customer repository. */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 */
	public List<CustomerRecord> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> new CustomerRecord(customer))
				.collect(Collectors.toList());
	}

	/**
	 * Adds the customer.
	 *
	 * @param customer
	 *            the customer
	 * @return the customer record
	 */
	public CustomerRecord addCustomer(Customer customer) {

		Customer savedCustomer = customerRepository.save(customer);
		return new CustomerRecord(savedCustomer);
	}

	/**
	 * Update customer.
	 *
	 * @param customerToUpdate
	 *            the customer to update
	 * @return the customer record
	 */
	public CustomerRecord updateCustomer(Customer customerToUpdate) {

		Customer customer = customerRepository
				.findById(customerToUpdate.getCustomerID()).get();
		// Update fields
		Consumer<String> updateIfNotEmpty = (value) -> {
			if (value != null && !value.isEmpty())
				customer.setName(value);
		};

		Consumer<Integer> updateIfPositive = (value) -> {
			if (value != null && value > 0)
				customer.setStreetNumber(value);
		};

		// Update fields
		updateIfNotEmpty.accept(customerToUpdate.getName());
		updateIfPositive.accept(customerToUpdate.getStreetNumber());
		updateIfNotEmpty.accept(customerToUpdate.getStreetName());
		updateIfNotEmpty.accept(customerToUpdate.getPostalCode());
		updateIfNotEmpty.accept(customerToUpdate.getState());
		updateIfNotEmpty.accept(customerToUpdate.getCountry());
		updateIfNotEmpty.accept(customerToUpdate.getPhoneNumber());

		Customer savedCustomer = customerRepository.save(customer);
		return new CustomerRecord(savedCustomer);
	}

	/**
	 * Delete customer by id.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteCustomerById(Integer id) {
		customerRepository.deleteById(id);
	}

}
