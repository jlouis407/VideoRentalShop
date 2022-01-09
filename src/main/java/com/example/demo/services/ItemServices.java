package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServices {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> listAllItems(){
		return itemRepository.findAll();
	}
	
	public Item getItemByUpc(Long upc) {
		return itemRepository.findById(upc).get();
	}
	
	public Item addItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	public ResponseEntity<Item> updateItem(@PathVariable Long upc, @RequestBody Item itemDetails){
		
		Item item = itemRepository.findById(upc)
				.orElseThrow(() -> new ResourceNotFoundException("Item with upc: " + upc + " does not exist."));
		
		item.setTitle(itemDetails.getTitle());
		
		Item updatedItem = itemRepository.save(item);
		return ResponseEntity.ok(updatedItem);
	}

}
