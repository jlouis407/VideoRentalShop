package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {
	
	
	@GetMapping("index")
	public String goHome() {
		return "index";
	}
	
	@GetMapping("logoutSuccess")
	public String logout() {
		return "logoutSuccess";
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
	
	@GetMapping("customerProfile")
	public String customerProfile() {
		return "customerProfile";
	}
	
	@GetMapping("clerkProfile")
	public String clerkProfile() {
		return "clerkProfile";
	}
	
	@GetMapping("movies")
	public String goToMovies() {
		return "movies";
	}
	
	@GetMapping("tvShows")
	public String goToTVShows() {
		return "tvShows";
	}
	
	@GetMapping("videoGames")
	public String goToVideoGames() {
		return "videoGames";
	}
	
	@GetMapping("itemsRented")
	public String goToItemsRented() {
		return "itemsRented";
	}
	
	@GetMapping("itemsRentedPrev")
	public String goToItemsRentedPrev() {
		return "itemsRentedPrev";
	}
	
	@GetMapping("editCustomer")
	public String goToEditCustomer() {
		return "editCustomer";
	}
	
	@GetMapping("editClerk")
	public String goToEditClerk() {
		return "editClerk";
	}
	
	@GetMapping("customers")
		public String goToCustomers() {
			return "customers";
		}
	}



