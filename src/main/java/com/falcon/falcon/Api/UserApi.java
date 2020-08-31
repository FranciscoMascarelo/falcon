package com.falcon.falcon.Api;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.falcon.falcon.dto.PaginatedResourceDto;
import com.falcon.falcon.dto.UserDto;

public interface UserApi {

	@PostMapping("/api/v1/user")
	UserDto createUser(@Valid @RequestBody final UserDto userDto);

	@GetMapping("/api/v1/users")
	PaginatedResourceDto<UserDto> getUsers(
			@RequestParam(name = "page", defaultValue = "0") @Valid @Min(0) final int page,
			@RequestParam(name = "limit", defaultValue = "10") @Valid @Min(1) @Max(20) final int limit);

	@GetMapping("/api/v1/user/{id}")
	UserDto findUser(@Valid @PathVariable(name = "id") long idUser);
	
	@PutMapping("/api/v1/user/{id}")
	UserDto updateUser(@Valid @PathVariable(name = "id") long idUser, @RequestBody UserDto userDto);
}
