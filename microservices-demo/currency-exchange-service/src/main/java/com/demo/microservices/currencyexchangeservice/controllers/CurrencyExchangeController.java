package com.demo.microservices.currencyexchangeservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.currencyexchangeservice.models.CurrencyExchange;
import com.demo.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		
		if(currencyExchange == null)
			throw new RuntimeException("Unable to find data from " + from + " to " + to);
		
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}

}
