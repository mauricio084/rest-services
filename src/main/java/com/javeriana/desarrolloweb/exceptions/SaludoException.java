package com.javeriana.desarrolloweb.exceptions;

//@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class SaludoException extends RuntimeException {

	public SaludoException(String nombre) {
		super(nombre);
	}
}
