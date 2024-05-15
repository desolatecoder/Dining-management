package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Repository.CustomerRepository;
import com.ctsdms.project.Service.CustomerService;

@RestController
@RequestMapping("dining")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	CustomerRepository crepo;
	
	@GetMapping("/customer/count")
	public Long getcountofentries() {
		Long l=crepo.countofentries();
		return l;
	}
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/customer/add")
	public Customer addcustomer(@RequestBody Customer customer) {
		Customer cust=service.addCustomer(customer);
		return cust;
	}
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/customer")
	public List<Customer> findallcustomers(){
		List<Customer> customers=service.FindAllCustomers();
		return customers;
	}
	@GetMapping("/customer/{customer_id}")
	public Customer findbyid(@PathVariable Long customer_id) {
		Customer c=service.findCustomerById(customer_id);
		return c;
	}
	
	@PutMapping("/customers/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer c=service.updateCustomer(customer);
		return c;
	}
	
	@DeleteMapping("/customer/delete/{customer_id}")
	public void deletecustomer(@PathVariable Long customer_id) {
		service.deleteCustomer(customer_id);
	}
}
