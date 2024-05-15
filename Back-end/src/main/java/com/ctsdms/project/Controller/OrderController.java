package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.Order;
import com.ctsdms.project.Service.OrderService;

@RestController
@RequestMapping("/dining")
public class OrderController {
	
	@Autowired
	OrderService service;
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/order/add")
	public Order addorder(@RequestBody Order order) {
		Order o=service.addOrder(order);
		return o;
	}
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/order/getall")
	public List<Order> getallorders(){
		List<Order> l=service.findallorders();
		return l;
	}
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/getbyid/{order_id}")
	public Order getbyid(@PathVariable Long order_id) {
		Order o=service.findorderbyid(order_id);
		return o;
	}
	@CrossOrigin("http://localhost:3000")
	@DeleteMapping("/order/delete/{order_id}")
	public void deletebyid(@PathVariable Long order_id) {
		service.deleteorderbyid(order_id);
	}
}
