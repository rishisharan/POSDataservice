package com.posdataservice.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posdataservice.model.Order;
import com.posdataservice.model.OrderStatus;
import com.posdataservice.repository.OrderRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	public Flux<Order> getAllOrders() {	
		return Flux.fromIterable(orderRepository.findAll());
	}

	public Order postAnOrder(Order order) {
		return orderRepository.insert(order);
	}

	public Order updateAnOrder(String id, OrderStatus status) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			order.setOrderStatus(status);
            return orderRepository.save(order);
        } else {
        	throw new EntityNotFoundException("Order not found.");
        }
	}	

}
