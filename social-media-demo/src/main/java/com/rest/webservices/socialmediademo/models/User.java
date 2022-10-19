package com.rest.webservices.socialmediademo.models;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private int id;
	
	@JsonProperty("user_name")
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	
	@JsonProperty("birth_date")
	@Past(message = "Birthdate sould be in the past")
	private LocalDate birthDate;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}

