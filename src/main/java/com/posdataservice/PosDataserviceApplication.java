package com.posdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.posdataservice")
@EnableFeignClients
public class PosDataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosDataserviceApplication.class, args);
	}

}
