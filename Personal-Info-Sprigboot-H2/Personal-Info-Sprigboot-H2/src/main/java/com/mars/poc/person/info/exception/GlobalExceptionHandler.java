package com.mars.poc.person.info.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException exp , WebRequest req){
		ErrorDetails err = new ErrorDetails(new Date(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity(err, HttpStatus.NOT_FOUND); 
	}
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception exp , WebRequest req){
    	ErrorDetails err = new ErrorDetails(new Date(), exp.getMessage(), req.getDescription(false));
    	return new ResponseEntity(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
