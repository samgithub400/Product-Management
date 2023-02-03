package com.ios.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ios.dto.CustomerDTO;
import com.ios.exception.CustomerNotFoundException;
import com.ios.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	ResponseEntity<Object> findCustomerById(long cusomerId) throws CustomerNotFoundException;

	ResponseEntity<Object> findCustomerByName(String customerName) throws CustomerNotFoundException;

	ResponseEntity<List<CustomerDTO>> findCustomerByProduct(String productName) throws CustomerNotFoundException;

}
