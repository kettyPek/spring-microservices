package com.demo.microservices.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	@GetMapping("/sample-api")
	public String sampleApi() {
		logger.info("sample API call received");
		return new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class).getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Fallback-response";
	}
}
