package com.posdataservice.POSDataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.posdataservice.POSDataservice.model.Item;
import com.posdataservice.POSDataservice.service.ItemService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/items")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
	
	@Autowired
	ItemService itemService;

	@GetMapping
	public Flux<Item> getAllItems(){
		return itemService.fetchAllItems();
	}

	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		try {
			Item item2 = itemService.postAnItem(item);
			return new ResponseEntity<>(item2, HttpStatus.CREATED);	
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create an item.", e);
		}
	}
}
