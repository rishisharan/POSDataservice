package com.posdataservice.POSDataservice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.posdataservice.POSDataservice.model.Customer;
import com.posdataservice.POSDataservice.model.Item;
import com.posdataservice.POSDataservice.model.Order;
import com.posdataservice.POSDataservice.model.OrderStatus;
import com.posdataservice.POSDataservice.repository.OrderRepository;

@SpringBootApplication
public class PosDataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosDataserviceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(OrderRepository repository) {
		return args -> {
			
			
			BigDecimal price = new BigDecimal("13.99");
			Item sonaMasoori = new Item("Rice", "Sona masoori rice", 1, price, false, false);
			Item basmati = new Item("Rice", "Basmati rice", 1, price, false, false);			
			List<Item> items = new ArrayList<>();
			items.add(sonaMasoori);
			items.add(basmati);			
			Customer customer = new Customer("Shrika", "7324292590");
			LocalDateTime now = LocalDateTime.now();
 			Order order = new Order(items, customer, new BigDecimal("34.99"), OrderStatus.PENDING, new Date(), now);
			repository.insert(order);
			
		};
	}

}
