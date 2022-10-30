package com.demo.microservices.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservices.currencyexchangeservice.models.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
