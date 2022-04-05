package com.javeriana.desarrolloweb.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javeriana.desarrolloweb.exceptions.SaludoException;

@ControllerAdvice
public class SaludoAdvice {

	@ResponseBody
	@ExceptionHandler({SaludoException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	String handleException(SaludoException e) {
		return e.getMessage();
	}
	
	
}
