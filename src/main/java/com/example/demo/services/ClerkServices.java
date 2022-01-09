package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Clerk;
import com.example.demo.repository.ClerkRepository;

@Service
public class ClerkServices {
	
	@Autowired
	private ClerkRepository clerkRepository;
	
	public Clerk createClerk(@RequestBody Clerk clerk) {
		return clerkRepository.save(clerk);
	}
	
	public ResponseEntity<Clerk> updateClerk(@PathVariable Long id, @RequestBody Clerk clerkDetails){
		
		Clerk clerk = clerkRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Clerk with id: " + id + " does not exist."));
		
		clerk.setUsername(clerkDetails.getUsername());
		clerk.setPassword(clerkDetails.getPassword());
		
		Clerk updatedClerk = clerkRepository.save(clerk);
		return ResponseEntity.ok(updatedClerk);
	}

}
