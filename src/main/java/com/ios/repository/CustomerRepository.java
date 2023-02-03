package com.ios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ios.dto.CustomerDTO;
import com.ios.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT * FROM Customer WHERE customer_name = ?1", nativeQuery = true)
	public Customer findByName(String customerName);

	@Query("select new com.ios.dto.CustomerDTO(c.customerName,p.productName,p.price) from Customer c join c.productList p where p.productName=?1")
	public List<CustomerDTO> findCustomerByProduct(String productName);

}
