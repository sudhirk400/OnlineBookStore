package com.sudhirk400.bookstore.service;
import java.util.List;
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
        return customers.stream()
                .map(customer -> new CustomerRecord(customer)).collect(Collectors.toList());
    }
    
    /**
     * Gets the customer by id.
     *
     * @param id the id
     * @return the customer by id
     */
    public CustomerRecord getCustomerById(Integer id) {
    	Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    	return new CustomerRecord(customer);
    }
    
    /**
     * Adds the customer.
     *
     * @param customer the customer
     * @return the customer record
     */
    public CustomerRecord addCustomer(Customer customer) {
  	
    	Customer savedCustomer =  customerRepository.save(customer);
    	return new CustomerRecord(savedCustomer);
    } 
    
    /**
     * Update customer.
     *
     * @param customerToUpdate the customer to update
     * @return the customer record
     */
    public CustomerRecord updateCustomer(Customer customerToUpdate) {
      	
    	Customer  customer = customerRepository.findById(customerToUpdate.getCustomerID()).get();
		// Update fields
		if (customerToUpdate.getFirstName() != null && 
				!customerToUpdate.getFirstName().isEmpty()) {
			customer.setFirstName(customerToUpdate.getFirstName());
		}
		if (customerToUpdate.getLastName() != null && 
				!customerToUpdate.getLastName().isEmpty()) {
			customer.setLastName(customerToUpdate.getLastName());
		}
		if (customerToUpdate.getStreetNumber() != null && 
				(customerToUpdate.getStreetNumber() > 0 )) {
			customer.setStreetNumber(customerToUpdate.getStreetNumber());
		}			
		
		if (customerToUpdate.getStreetName() != null && 
				!customerToUpdate.getStreetName().isEmpty()) {
			customer.setStreetName(customerToUpdate.getStreetName());
		}
		if (customerToUpdate.getPostalCode() != null && 
				!customerToUpdate.getPostalCode().isEmpty()) {
			customer.setPostalCode(customerToUpdate.getPostalCode());
		}	
				
		if (customerToUpdate.getState() != null && 
				!customerToUpdate.getState().isEmpty()) {
			customer.setState(customerToUpdate.getState());
		}
		if (customerToUpdate.getCountry() != null && 
				!customerToUpdate.getCountry().isEmpty()) {
			customer.setCountry(customerToUpdate.getCountry());
		}	
		if (customerToUpdate.getPhoneNumber() != null && 
				!customerToUpdate.getPhoneNumber().isEmpty()) {
			customer.setPhoneNumber(customerToUpdate.getPhoneNumber());
		}

    	Customer savedCustomer =  customerRepository.save(customer);
    	return new CustomerRecord(savedCustomer);
    } 
    


    /**
     * Delete customer by id.
     *
     * @param id the id
     */
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

}
