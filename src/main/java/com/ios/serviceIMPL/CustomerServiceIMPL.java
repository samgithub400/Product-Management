package com.ios.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ios.dto.CustomerDTO;
import com.ios.exception.CustomerNotFoundException;
import com.ios.model.Customer;
import com.ios.repository.CustomerRepository;
import com.ios.service.CustomerService;

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public ResponseEntity<Object> findCustomerById(long cusomerId) throws CustomerNotFoundException {
		Customer customer = customerRepository.findById(cusomerId)
				.orElseThrow(() -> new CustomerNotFoundException("NOT FOUND...!"));
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findCustomerByName(String customerName) throws CustomerNotFoundException {
		Customer customer = customerRepository.findByName(customerName);
		if (customer == null)
			throw new CustomerNotFoundException("NOT FOUND...!");
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CustomerDTO>> findCustomerByProduct(String productName)
			throws CustomerNotFoundException {

		List<CustomerDTO> customerList = customerRepository.findCustomerByProduct(productName);
		if (customerList == null || customerList.isEmpty())
			throw new CustomerNotFoundException("NOT FOUND..!");
		return new ResponseEntity<List<CustomerDTO>>(customerList, HttpStatus.FOUND);
	}
}
