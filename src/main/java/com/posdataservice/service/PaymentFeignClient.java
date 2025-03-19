package com.posdataservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payments", url = "http://localhost:8082/api/v1/payments")
public interface PaymentFeignClient {

	@GetMapping(value="/{paymentId}", consumes = "application/json")
	public ResponseEntity<String> retrivePaymentDetails(@PathVariable String paymentId);
}
