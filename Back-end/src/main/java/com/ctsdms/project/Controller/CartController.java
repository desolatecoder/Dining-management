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

import com.ctsdms.project.Entity.Cart;
import com.ctsdms.project.Service.CartService;

@RestController
@RequestMapping("/dining")
public class CartController {
	
	@Autowired 
	CartService service;
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/cart/add")
	public Cart addcart(@RequestBody Cart cart) {
		return service.addcart(cart);
	}
	
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/cart/getall")
	public List<Cart> getall(){
		return service.getallcarts();
	}
	
	@GetMapping("/cart/getbyid")
	public Cart getbyid(Long id) {
		return service.getcartbyid(id);
	}
	@CrossOrigin("http://localhost:3000/")
	@PostMapping("/update")
	public Cart updateCart(@RequestBody Cart cart) {
		return service.updateCart(cart);
	}
	
	@CrossOrigin("http://localhost:3000")
	@DeleteMapping("/cart/delete/{cart_id}")
	public void deletecart(@PathVariable Long cart_id) {
		service.deletebyid(cart_id);
	}

}
