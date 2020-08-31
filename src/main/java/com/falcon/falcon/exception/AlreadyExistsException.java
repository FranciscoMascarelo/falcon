package com.falcon.falcon.exception;

import java.io.Serializable;
import java.util.function.Supplier;

public class AlreadyExistsException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public AlreadyExistsException() {
		super("Resource already exists.");
	}
	
	static public Supplier<? extends RuntimeException> supply(){
		return () -> new AlreadyExistsException();
	}
}
