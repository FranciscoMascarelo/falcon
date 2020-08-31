package com.falcon.falcon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.falcon.Api.UserApi;
import com.falcon.falcon.dto.PaginatedResourceDto;
import com.falcon.falcon.dto.UserDto;
import com.falcon.falcon.service.UserService;

@Validated
@RestController
public class UserController implements UserApi{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDto createUser(final UserDto dto) {
		return userService.createUser(dto);
	}
	
	@Override
	public PaginatedResourceDto<UserDto> getUsers(final int pageNumber, final int limit) {
		return userService.findUser(pageNumber, limit);
	}

	@Override
	public UserDto updateUser(@Valid long idUser, UserDto userDto) {
		return userService.updateUser(idUser, userDto);
	}

	@Override
	public UserDto findUser(@Valid long idUser) {
		return userService.findUser(idUser);
	}
}
