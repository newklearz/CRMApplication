package com.costinsuhan.springdemo.dao;

import java.util.List;

import com.costinsuhan.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
	public List<Customer> getCustomers(int theSortField);
	
}
