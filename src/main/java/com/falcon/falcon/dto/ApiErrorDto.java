package com.falcon.falcon.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ApiErrorDto {
	private Instant timestamp;
	private String message;
	private String type;
	private Integer code;
	private String path;
	private String stackTrace;
	private String traceId;
	private String spanId;

}
