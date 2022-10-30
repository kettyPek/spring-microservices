package com.demo.microservices.currencyexchangeservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.currencyexchangeservice.models.CurrencyExchange;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = new CurrencyExchange(100l, from, to, BigDecimal.valueOf(50), "");
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}

}
