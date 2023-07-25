package com.posdataservice.POSDataservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document
@Getter
@Setter
public class Order {

	@Id
	private String orderId;
	private List<Item> items;
	private Customer customer;
	private BigDecimal total;
	private OrderStatus orderStatus;
	private Date orderCreatedDate;
	private LocalDateTime orderCreationTime;
	
	public Order(List<Item> items, Customer customer, BigDecimal total, OrderStatus orderStatus,
			Date orderCreatedDate, LocalDateTime orderCreationTime) {
		super();
		this.items = items;
		this.customer = customer;
		this.total = total;
		this.orderStatus = orderStatus;
		this.orderCreatedDate = orderCreatedDate;
		this.orderCreationTime = orderCreationTime;
	}


}
