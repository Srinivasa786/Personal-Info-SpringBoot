package com.mars.poc.person.info.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = -2310134323828801169L;
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
