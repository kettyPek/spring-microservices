package com.rest.webservices.socialmediademo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


@RestController
@RequestMapping("/filtering")
public class FilteringController {

	@GetMapping
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		// Dynamic filtering
		MappingJacksonValue mappungJacksonValue = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mappungJacksonValue.setFilters(filters);
		
		return mappungJacksonValue;
	}

	@GetMapping("/list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6"));
	}

}
