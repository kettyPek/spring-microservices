package com.demo.microservices.currencyexchangeservice.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyExchange {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;

}
