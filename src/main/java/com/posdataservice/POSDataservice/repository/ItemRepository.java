package com.posdataservice.POSDataservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.posdataservice.POSDataservice.model.Item;

public interface ItemRepository extends MongoRepository<Item, String>{

}
