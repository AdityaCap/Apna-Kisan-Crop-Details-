package com.cropDetails.User.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResourceAlreadyExistsException extends Exception {

	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}