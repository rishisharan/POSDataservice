package com.posdataservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "roles")
@Getter
@Setter
public class Role {
	@Id
	private String id;

	private ERole name;

	public ERole getName() {
		return name;
	}
}
