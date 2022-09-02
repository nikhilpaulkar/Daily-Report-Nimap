package com.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException
{
//handle  exception

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity <Errordetails>handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
		Errordetails errordetails = new Errordetails(new Date(), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
	}


}