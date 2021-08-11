package com.costinsuhan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.costinsuhan.springdemo.entity.Customer;
import com.costinsuhan.springdemo.service.CustomerService;
import com.costinsuhan.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel, @RequestParam(required = false) String sort) {
		
		// get customers from the service
		
		List <Customer> theCustomers = null;
		
		if(sort!=null) {
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomer(theSortField);
		} 
		else {
			// no sort field provided ... default sorting by last name
			
			theCustomers = customerService.getCustomer(SortUtils.LAST_NAME);
		}
		
		// add the customers to the model 
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model atribute to bind form data
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping ("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate (@RequestParam("customerId") int theId, Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomers(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		// send over to our form
		return "customer-form";
		
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer (@RequestParam("customerId") int theId) {
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list" ;
	
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		// search customers from the service
		
		List<Customer> theCustomers = customerService.searchCustomers (theSearchName);
		
		// add the customers to the model
		
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
		
		
	
	
}


