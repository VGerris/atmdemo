package com.example.simpleatm.converter;

import java.util.stream.Collectors;

import com.example.simpleatm.dto.UserDto;
import com.example.simpleatm.entity.User;

/**
 * Created by ashish on 13/5/17.
 */
public class UserConverter {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User(userDto.getUserName(), null);
		user.setUserId(userDto.getUserId());
		user.setAccounts(userDto.getAccountDtos().stream().map(AccountConverter::dtoToEntity).collect(Collectors.toList()));
		return user;
	}

	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), null);
		userDto.setAccountDtos(user.getAccounts().stream().map(AccountConverter::entityToDto).collect(Collectors.toList()));
		return userDto;
	}
}
