package com.erizoka.xpto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullIdException extends NullPointerException{
	private static final long serialVersionUID = 1L;

	public NullIdException(String msg) {
		super(msg);
	}
}