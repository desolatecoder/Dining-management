package com.ctsdms.project.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.CustomeException.StudentNotFoundException;
import com.ctsdms.project.Entity.Cart;
import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Entity.Food;
import com.ctsdms.project.Entity.Order;
import com.ctsdms.project.Repository.CartRepository;
import com.ctsdms.project.Repository.CustomerRepository;
import com.ctsdms.project.Repository.FoodRepository;
import com.ctsdms.project.Repository.OrderRepository;

@Service
public class OrderServiceClass implements OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	FoodRepository repo1;
	
	@Autowired
	OrderService service;
	
	@Autowired
	FoodService service1;
	
	@Autowired
	CartRepository cartrepo;
	
	@Autowired
	CustomerRepository custrepo;
	
	@Override
	public Order addOrder(Order order) {
		List<Cart> cartitems=cartrepo.findUserById(order.getCustomer().getCustomer_id());
		Double price=0.0;
		Long custquantity=0L;
		for(Cart ci: cartitems) {
			Food food=repo1.findById(ci.getFood().getFood_id()).get();
			
			if(!(food.getQuantity()<ci.getQuantity())) {
				price+=ci.getPrice()*ci.getQuantity();
				custquantity+=ci.getQuantity();
				food.setQuantity(food.getQuantity()-ci.getQuantity());
				repo1.save(food);
				cartrepo.delete(ci);
			}
			
		}
		order.setOrder_status("order placed");
		order.setQuantity(custquantity);
		order.setTotalprice(price);
		order.setTracking_id("Ord"+custquantity+custrepo.findById(order.getCustomer().getCustomer_id()).get().getName());
		order.setCustomer(custrepo.findById(order.getCustomer().getCustomer_id()).get());
		return repo.save(order);
	}
	@Override
	public List<Order> findallorders() {
		List<Order> orders=repo.findAll();
		return orders;
	}

	@Override
	public Order findorderbyid(Long id) {
	try {
		return repo.findById(id).get();
	}
	catch(Exception e){
		throw new StudentNotFoundException("Data not found!!");
	}		
}
	@Override
	public void deleteorderbyid(Long id) {
		// TODO Auto-generated method stub
		Optional<Order> order=repo.findById(id);
		Order orderr=order.get();
		repo.delete(orderr);	
	}
	@Override
	public Order updateCustomer(Order order) {
			Order c=repo.saveAndFlush(order);
			return c;
	}

}
