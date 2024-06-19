package com.se.service;

import java.util.List;

import com.se.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomer();
	public void addCustomer(Customer customer);
	public void delete(int idDelete);
	public Customer update(int idUpdate);


}
