package com.rest.webservices.socialmediademo.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@JsonFilter("someBeanFilter")
public class SomeBean {
	
//	@JsonIgnore //static filtering
	private String field1;
	
	private String field2;
	
	private String field3;

}
