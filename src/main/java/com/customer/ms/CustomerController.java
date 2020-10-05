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

import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CustomerService customerService;

	
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

	
	@RequestMapping(value="/mongoCustomers",method = RequestMethod.GET,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public List<CustomerM> getMongoCustomers(){
		List<CustomerM> list = customerService.findAll();
		return list;
	
	}
	
	@RequestMapping(value="/mongoCustomers/{cusId}",method = RequestMethod.GET,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public CustomerM getMongoCustomer(@PathVariable("cusId") String cusId) {
		
		return customerService.findById(cusId);
		}
	@RequestMapping(value="/mongoCustomer",method = RequestMethod.POST,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public CustomerM addMongoCustomer(@RequestBody CustomerM customer){
		
		return customerService.addCustomer(customer);
		}
	
	
	@RequestMapping(value="/delmongoCustomers",method = RequestMethod.POST,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public String  delMongoCustomer(@RequestBody CustomerM customer)
	{
		return customerService.delCustomer(customer);
	}
	
	@RequestMapping(value="/mongoCustomers/{cusId}",method = RequestMethod.POST,produces = (MediaType.APPLICATION_PROBLEM_JSON_VALUE))
	public CustomerM UPDMongoCustomer(@RequestBody CustomerM customer) {
		
		return customerService.updCustomer(customer);
		}


}
