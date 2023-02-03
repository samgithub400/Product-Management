package com.ios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ios.dto.CustomerDTO;
import com.ios.exception.CustomerNotFoundException;
import com.ios.model.Customer;
import com.ios.service.CustomerService;

@RestController
@RequestMapping("/app")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("Testing.....");
		return "Success...!";
	}
	
	@PostMapping("/save-customer")
	public Customer saveCustomer(@RequestBody Customer customer) {		
		return service.saveCustomer(customer);
	}
	@GetMapping("/get-customer-by-id/{cusomerId}")
	public ResponseEntity<Object> findCustomerById(@PathVariable("cusomerId") long cusomerId) throws CustomerNotFoundException {
		return service.findCustomerById(cusomerId);

	}
	
	@GetMapping("/find-by-customer-name/{customerName}")
	public ResponseEntity<Object> findCustomerByName(@PathVariable("customerName") String customerName) throws CustomerNotFoundException {
		return service.findCustomerByName(customerName);
	}
	
	@GetMapping("/find-customer-by-product/{productName}")
	public ResponseEntity<List<CustomerDTO>> findCustomerByProduct(@PathVariable("productName") String productName) throws CustomerNotFoundException {
		return service.findCustomerByProduct(productName);
	}
	
}
