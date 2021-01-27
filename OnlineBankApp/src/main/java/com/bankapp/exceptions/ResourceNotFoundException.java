package com.bankapp.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8292185762375491962L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
