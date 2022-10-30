package com.demo.microservices.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.microservices.currencyconversionservice.CurrencyExchangeProxy;
import com.demo.microservices.currencyconversionservice.models.CurrencyConvertionValue;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConverterController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

//	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConvertionValue calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity) {
//
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//
//		ResponseEntity<CurrencyConvertionValue> responseEntity = new RestTemplate().getForEntity(
//				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConvertionValue.class,
//				uriVariables);
//
//		CurrencyConvertionValue convertionValue = responseEntity.getBody();
//
//		return new CurrencyConvertionValue(convertionValue.getId(), from, to,
//				quantity.multiply(convertionValue.getConversionMultiple()), convertionValue.getConversionMultiple(),
//				quantity, convertionValue.getEnvironment());
//	}

	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionValue calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConvertionValue convertionValue = currencyExchangeProxy.retrieveExchangeValue(from, to);
		

		return new CurrencyConvertionValue(convertionValue.getId(), from, to,
				quantity.multiply(convertionValue.getConversionMultiple()), convertionValue.getConversionMultiple(),
				quantity, convertionValue.getEnvironment());
	}
}
