package com.example.simpleatm.service.impl;

import com.example.simpleatm.converter.UserConverter;
import com.example.simpleatm.dto.UserDto;
import com.example.simpleatm.repository.UserRepository;
import com.example.simpleatm.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ashish on 13/5/17.
 */
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto getUserById(Integer userId) {
		return UserConverter.entityToDto(userRepository.getOne(userId));
	}

	@Override
	public void saveUser(UserDto userDto) {
		userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public void saveUserBalance(UserDto userDto) {
		saveUser(userDto);
	}

	@Override
	public Float withdrawFunds(UserDto userDto, Float withdrawal) {
		userDto.getAccountDtos().get(0).removeBalance(withdrawal);
		saveUser(userDto);
		return withdrawal;
	}

	@Override
	public Float depositFunds(UserDto userDto, Float deposit) {
		userDto.getAccountDtos().get(0).addBalance(deposit);
		saveUser(userDto);
		return deposit;
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
	}
}
