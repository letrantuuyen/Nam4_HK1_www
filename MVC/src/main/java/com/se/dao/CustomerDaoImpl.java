package com.se.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.se.entity.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	private final SessionFactory sessionFatory;

	@Autowired
	public CustomerDaoImpl(SessionFactory sessionFatory) {
		super();
		this.sessionFatory = sessionFatory;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		Session currentSession = sessionFatory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		Session currentSession = sessionFatory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(int idDelete) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFatory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Customer where id=: customerId ");
		theQuery.setParameter("customerId", idDelete);
		theQuery.executeUpdate();
		
	}

	@Override
	public Customer update(int idUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

}
