package com.rest.webservices.socialmediademo.models;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
	
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	
	@Past(message = "Birthdate sould be in the past")
	private LocalDate birthDate;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}

