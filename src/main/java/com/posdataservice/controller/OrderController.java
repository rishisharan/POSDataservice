package com.posdataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.posdataservice.model.Order;
import com.posdataservice.model.OrderStatus;
import com.posdataservice.service.OrderService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	

	@Autowired
	private final OrderService orderService;
	

	@GetMapping
	public Flux<Order> fetchAllOrders(){		
		return orderService.getAllOrders();
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		try {
			Order order2 = orderService.postAnOrder(order);
			return new ResponseEntity<>(order2, HttpStatus.CREATED);	
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to place an order", e);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestParam OrderStatus orderStatus) {
		try {
			Order order2 = orderService.updateAnOrder(id, orderStatus);
			return new ResponseEntity<>(order2, HttpStatus.CREATED);	
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update an order", e);
		}
	}
	
	
}
