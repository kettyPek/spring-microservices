package com.demo.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.limitsservice.bean.Limits;
import com.demo.microservices.limitsservice.configuration.Configuration;

@RestController
@RequestMapping("/limits")
public class LimitsController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping
	public Limits retriveLimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}

}
