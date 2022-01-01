package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Customer;
import com.example.demo.service.UserDetailsServiceImpl;

@Controller
public class CustomerController {
	
	@Autowired
	private UserDetailsServiceImpl customerService;
	
	@GetMapping("/customers")
	public String getCustomers(Model model) {
		List<Customer> customerList = customerService.getCustomers();
		model.addAttribute("customers", customerList);
		return "customers";
	}
	

}
