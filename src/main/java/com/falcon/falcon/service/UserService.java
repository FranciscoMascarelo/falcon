package com.falcon.falcon.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.falcon.falcon.Mapper.UserMapper;
import com.falcon.falcon.domain.User;
import com.falcon.falcon.dto.PaginatedResourceDto;
import com.falcon.falcon.dto.UserDto;
import com.falcon.falcon.exception.ConstraintViolationException;
import com.falcon.falcon.repository.UserRepository;
import com.google.common.base.Preconditions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	public UserDto createUser(UserDto dto) {
		Preconditions.checkArgument(dto.getName() != null, "Name is required");

		final User createEntity = userMapper.toEntity(dto);
		final User newEntity = userRepository.save(createEntity);

		return userMapper.toDto(newEntity);
	}

	public PaginatedResourceDto<UserDto> findUser(final int pageNumber, final int limit) {
		final Sort sort = Sort.by("createdDate").descending();
		final PageRequest pageRequest = PageRequest.of(pageNumber, limit, sort);
		Page<User> page = userRepository.findAll(pageRequest);
		return userMapper.toDto(page);
	}

	public UserDto updateUser(@Valid long idUser, UserDto userDto) {
		final User findUser = userRepository.findById(idUser)
				.orElseThrow(ConstraintViolationException.supply("User not found"));
		
		final User updateEntity = userMapper.updateEntity(findUser, userDto);
		userRepository.save(updateEntity);
		return userMapper.toDto(updateEntity);
	}

	public UserDto findUser(@Valid long idUser) {
		User user = userRepository.findById(idUser).orElseThrow(ConstraintViolationException.supply("User not found"));
		return userMapper.toDto(user);
	}
}
