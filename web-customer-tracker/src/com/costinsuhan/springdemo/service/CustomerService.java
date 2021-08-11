package com.costinsuhan.springdemo.service;

import java.util.List;

import com.costinsuhan.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
	public List<Customer> getCustomer(int theSortField);
}
