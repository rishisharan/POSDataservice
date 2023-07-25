package com.posdataservice.POSDataservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.posdataservice.POSDataservice.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
