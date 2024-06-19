package com.se.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.CustomerDao;
import com.se.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private final CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCustomer() {	
		return customerDao.getAllCustomer(); 
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
		
	}

	@Override
	public void delete(int idDelete) {
		// TODO Auto-generated method stub
		customerDao.delete(idDelete);
	}

	@Override
	public Customer update(int idUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

}
