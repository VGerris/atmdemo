package com.example.simpleatm.service;

import java.util.List;

import com.example.simpleatm.dto.UserDto;

/**
 * Created by ashish on 13/5/17.
 */
public interface UserService {
    UserDto getUserById(Integer userId);
    void saveUser(UserDto userDto);
    void saveUserBalance(UserDto userDto);
    Float withdrawFunds(UserDto userDto, Float withdrawal);
    Float depositFunds(UserDto userDto, Float deposit);
    List<UserDto> getAllUsers();
}
