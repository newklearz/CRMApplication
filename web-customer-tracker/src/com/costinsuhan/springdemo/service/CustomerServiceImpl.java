package com.costinsuhan.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costinsuhan.springdemo.dao.CustomerDAO;
import com.costinsuhan.springdemo.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomer();
	}
	
	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}
	
	
	@Override
	@Transactional
	public List<Customer> getCustomer(int theSortField) {
		return customerDAO.getCustomers(theSortField);
	}
	
	

}
