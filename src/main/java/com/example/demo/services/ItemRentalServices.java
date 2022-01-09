package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.ItemRental;
import com.example.demo.repository.ItemRentalRepository;

@Service
public class ItemRentalServices {
	
	@Autowired
	private ItemRentalRepository itemRentalRepository;
	
	public List<ItemRental> getAllItemRentals(){
		return itemRentalRepository.findAll();
	}
	
	public ItemRental getItemRentalById(Long id) {
		return itemRentalRepository.findById(id).get();
	}
	
	public ItemRental createItemRental(@RequestBody ItemRental itemRental) {
		return itemRentalRepository.save(itemRental);
		
	}

}
