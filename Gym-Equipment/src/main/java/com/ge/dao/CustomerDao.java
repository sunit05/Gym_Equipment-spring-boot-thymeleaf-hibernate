package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Customer;
import com.ge.repository.CustomerRepository;

@Component
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteCustomerById(long id) {
		customerRepository.deleteById(id);
	}

	public void updateCustomer(Customer customer) {
		long id = customer.getId();
		Customer customer2 = customerRepository.findById(id).get();
		customer2.setName(customer.getName());
		customer2.setAddress(customer.getAddress());
		customer2.setContactNo(customer.getContactNo());
		customer2.setEmail(customer.getEmail());
		customer2.setUsername(customer.getUsername());
		customer2.setPassword(customer.getPassword());
	}
	

//		if (customer.getUsername() == null) {
//			customer2.setUsername(customer2.getUsername());
//		}
//		else if(customer.getUsername() != null){
//			customer2.setUsername(customer.getUsername());
//		}

}
