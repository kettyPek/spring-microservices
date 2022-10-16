package com.rest.webservices.socialmediademo.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {

	private LocalDateTime timeStamp;
	private String message;
	private String details;

}
