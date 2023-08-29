package com.posdataservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.posdataservice.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{
	List<Item> findByTitleContainingIgnoreCase(String searchTerm);
}
