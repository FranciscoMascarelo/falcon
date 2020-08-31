package com.falcon.falcon.exception;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.falcon.falcon.dto.ApiErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExceptionDecoder {

	@Autowired
	private ObjectMapper objectMapper;

	public Exception decode(final InputStream body) {
		try {
			final ApiErrorDto error = objectMapper.readValue(body, ApiErrorDto.class);

			if (error.getType().equals(AlreadyExistsException.class.getName())) {
				return new AlreadyExistsException();
			}

			if (error.getType().equals(ConstraintViolationException.class.getName())) {
				return new ConstraintViolationException(error.getMessage());
			}

			if (error.getType().equals(ResourceNotFoundException.class.getName())) {
				return new ResourceNotFoundException(error.getMessage());
			}

			if (error.getType().equals(IllegalArgumentException.class.getName())) {
				return new IllegalArgumentException(error.getMessage());
			}

		} catch (Exception e) {

		}

		return new RuntimeException("Failed to decode error");
	}

}
