package com.customer.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.DAO.CustomerDAO;
import com.customer.ms.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot 1.0";
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public List<Customer> getCustomers(){
		//List<Customer> list = customerDAO.getAllCustomers();
		return customerDAO.getAllCustomers();
	}
	
	
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.GET,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public Customer getCustomer(@PathVariable("cusId") String cusId){
		return customerDAO.getCustomer(cusId);
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerDAO.addCustomer(customer);
	}
	
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.POST,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public Customer updCustomer(@RequestBody Customer customer) {
		return customerDAO.updCustomer(customer);
	}
	
	@RequestMapping(value = "/delcustomer", method = RequestMethod.POST,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public Customer delCustomer(@RequestBody Customer customer) {
		return customerDAO.delCustomer(customer);
	}
}
