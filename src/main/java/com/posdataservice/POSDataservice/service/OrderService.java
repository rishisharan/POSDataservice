package com.posdataservice.POSDataservice.service;

import org.springframework.stereotype.Service;

import com.posdataservice.POSDataservice.model.Order;
import com.posdataservice.POSDataservice.repository.OrderRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepository orderRepository;

	public Flux<Order> getAllOrders() {	
		return Flux.fromIterable(orderRepository.findAll());
	}

	public Order postAnOrder(Order order) {
		return orderRepository.insert(order);
	}	

}
