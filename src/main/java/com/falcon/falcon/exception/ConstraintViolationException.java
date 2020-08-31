package com.falcon.falcon.exception;

import java.io.Serializable;
import java.util.function.Supplier;

public class ConstraintViolationException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -7956580010302359738L;

	public ConstraintViolationException(final String message) {
		super(message);
	}

	static public Supplier<? extends RuntimeException> supply(String message) {
		return () -> new ConstraintViolationException("Constraint Violation: " + message);
	}
}
