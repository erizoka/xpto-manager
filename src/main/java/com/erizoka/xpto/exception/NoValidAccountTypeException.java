package com.erizoka.xpto.exception;

public class NoValidAccountTypeException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoValidAccountTypeException(String msg) {
		super(msg);
	}
}
