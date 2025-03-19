package com.posdataservice.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.posdataservice.controller.AuthController;
import com.posdataservice.model.Order;
import com.posdataservice.model.OrderStatus;
import com.posdataservice.repository.OrderRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;


@Service
@AllArgsConstructor
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	PaymentFeignClient paymentFeignClient;
	
	public Flux<Order> getAllOrders() {	
		ResponseEntity<String> payment = paymentFeignClient.retrivePaymentDetails("123");
		logger.info("Payment details " + payment.getBody() + "Status code " + payment.getStatusCodeValue());
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
