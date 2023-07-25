package com.posdataservice.POSDataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posdataservice.POSDataservice.model.Item;
import com.posdataservice.POSDataservice.repository.ItemRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Flux<Item> fetchAllItems() {
		return Flux.fromIterable(itemRepository.findAll());
	}

	public Item postAnItem(Item item) {
		return itemRepository.insert(item);
	}

}
