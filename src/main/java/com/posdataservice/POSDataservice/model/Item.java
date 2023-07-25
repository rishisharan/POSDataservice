package com.posdataservice.POSDataservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Item {

	@Id
	private String itemId;
	private String title;
	private String description;
	private int quantity;
	private BigDecimal price;
	private boolean isTaxable;
	private boolean isAvailable;
	private Category category;
	
	public Item(String title, String description, int quantity, BigDecimal price, boolean isTaxable,
			boolean isAvailable) {
		super();
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.isTaxable = isTaxable;
		this.isAvailable = isAvailable;
	}
	

}
