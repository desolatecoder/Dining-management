package com.ctsdms.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.CustomeException.StudentNotFoundException;
import com.ctsdms.project.Entity.Admin;
import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Repository.AdminRepository;
import com.ctsdms.project.Repository.CustomerRepository;

import jakarta.persistence.EntityManager;

@Service
public class CustomerServiceClass implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	AdminRepository adminrepo;
	
	@Autowired
	EntityManager em;
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust=repo.save(customer);
		return cust;
	}

	@Override
	public List<Customer> FindAllCustomers() {
		List<Customer> customers=repo.findAll();
		return customers;
	}


	public Customer findCustomerById(Long id) {
	    try {
	    	return repo.findById(id).get();
	    }
	    catch(Exception e) {
	    	throw new StudentNotFoundException("No data found!!");
	    }
	}


	@Override
	public Customer updateCustomer(Customer customer) {
			Customer c=repo.saveAndFlush(customer);
			return c;
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		List<Customer> customers=repo.findAll();
		for(Customer c:customers) {
			if(c.getCustomer_id()==id) {
				repo.delete(c);
			}
		}
	}

}
