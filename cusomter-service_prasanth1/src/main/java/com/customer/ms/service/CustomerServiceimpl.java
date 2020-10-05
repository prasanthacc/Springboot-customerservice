package com.customer.ms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceimpl implements CustomerService {
	
	@Autowired
	private  CustomerRepository customerRepository;
	
	@Override
	public List<CustomerM> findAll(){
		return customerRepository.findAll();
	}
	
	@Override
	public CustomerM findById(String cusId) {
		Optional<CustomerM> opt = customerRepository.findById(cusId);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public CustomerM addCustomer(CustomerM customerM) {
		return customerRepository.save(customerM);
	}
	
	@Override
	public String delCustomer(CustomerM customerM) {
		
		//Optional<CustomerM> opt1 = customerRepository.findById(customerM.getCusId());
		//if (opt1.isPresent()) {
			customerRepository.delete(customerM);
			//return "delete success";
		//}
		 
		 return "delete success";
	}
	
	@Override
	public CustomerM updCustomer(CustomerM customerM) {
		 return customerRepository.save(customerM);
		 
	}
	
	
}
