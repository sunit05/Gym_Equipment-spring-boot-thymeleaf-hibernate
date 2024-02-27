package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.CustomerDao;
import com.ge.dto.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public List<Customer> getAllCustomers(){
		return customerDao.getAllCustomers();
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	public void deleteCustomerById(long id) {
		customerDao.deleteCustomerById(id);
	}
	
	public boolean customerLogin(Customer customer) {
		return customerDao.customerLogin(customer);
	}
	
}
