package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.Contact;
import com.ctsdms.project.Service.ContactService;

@RestController
@RequestMapping("/dining")
public class ContactController {
	@Autowired
	ContactService service;
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/contact/add")
	public Contact addcontact( @RequestBody Contact contact) {
		return service.addcontact(contact);
		
	}
	
	@GetMapping("/contact/getall")
	public List<Contact> getcontacts(){
		return service.getallcontact();
	}

}
