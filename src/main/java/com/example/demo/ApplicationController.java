package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("index")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("loginCustomer")
	public String customerLogin() {
		return "loginCustomer";
	}
	
	@GetMapping("loginClerk")
		public String clerkLogin() {
			return "loginClerk";
		}
	
	@GetMapping("signupCustomer")
	public String customerSignup() {
		return "signupCustomer";
	}
	
	@GetMapping("signupClerk")
	public String clerkSignup() {
		return "signupClerk";
	}
}


