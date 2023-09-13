package com.posdataservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posdataservice.model.Item;
import com.posdataservice.repository.ItemRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
public class ItemService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	ItemRepository itemRepository;
	
	public Flux<Item> fetchAllItems() {
		return Flux.fromIterable(itemRepository.findAll());
	}

	public Item postAnItem(Item item) {
//		LOGGER.info("Creating an item ", item.getItemId() , "title ",item.getTitle(), "price ", item.getPrice());
		return itemRepository.insert(item);
	}

	public Flux<Item> searchItems(String searchTerm) {
		return Flux.fromIterable(itemRepository.findByTitleContainingIgnoreCase(searchTerm));
	}

}
