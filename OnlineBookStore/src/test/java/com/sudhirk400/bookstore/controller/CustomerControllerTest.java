package com.sudhirk400.bookstore.controller;

 

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudhirk400.bookstore.dto.CustomerRecord;
import com.sudhirk400.bookstore.model.Customer;
import com.sudhirk400.bookstore.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean 
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer;
    private CustomerRecord customerRecord;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        customer = new Customer(1, "Sudhir", "Kumar", 210, "My Street", "560001", "Karnataka", "India",  "+911234567890");
        customerRecord = new CustomerRecord(customer);
        
        /*
         *     {
        "customerID": 1,
        "firstName": "FirstName1",
        "lastName": "LastName1",
        "streetNumber": 101,
        "streetName": "Street1",
        "postalCode": "PIN101",
        "state": "Assam",
        "country": "India",
        "phoneNumber": "+911234567890"
    }
         */
    }

    @Test
    void testGetAllCustomers() throws Exception {
        List<CustomerRecord> customers = Arrays.asList(customerRecord);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/customer/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Sudhir"));
    }
 
    @Test
    void testGetCustomerById() throws Exception {
        when(customerService.getCustomerById(1)).thenReturn(customerRecord);

        mockMvc.perform(get("/api/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Sudhir"));
    }

    @Test
    void testAddCustomer() throws Exception {
        when(customerService.addCustomer(any(Customer.class))).thenReturn(customerRecord);

        mockMvc.perform(post("/api/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Sudhir"));
    }

    @Test
    void testUpdateCustomer() throws Exception {
        when(customerService.updateCustomer(any(Customer.class))).thenReturn(customerRecord);

        mockMvc.perform(put("/api/customer/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Sudhir"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        doNothing().when(customerService).deleteCustomerById(1);

        mockMvc.perform(delete("/api/customer/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer is deleted successfully!"));
    }
     
}
