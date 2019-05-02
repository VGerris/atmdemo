package com.example.simpleatm.controller;

import com.example.simpleatm.dto.UserDto;
import com.example.simpleatm.service.UserService;
import com.example.simpleatm.utils.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ashish on 13/5/17.
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(Constants.GET_USER_BY_ID)
    public UserDto getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(Constants.GET_ALL_USERS)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = Constants.SAVE_USER, method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @RequestMapping(value = Constants.SAVE_USER_BALANCE, method = RequestMethod.POST)
    public void saveUserBalance(@RequestBody UserDto userDto) {
        userService.saveUserBalance(userDto);
    }

    @RequestMapping(value = Constants.WITHDRAW_FUNDS, method = RequestMethod.POST)
    public void withdrawFunds(@RequestBody UserDto userDto, @PathVariable Float withdraw) {
        if ( withdraw != 0  && !withdraw.isNaN() ) {
            userService.withdrawFunds(userDto, withdraw);
        } else {
            System.out.println("withdrawFunds received an invalid amount, NOT sending.");
        }
    }

    @RequestMapping(value = Constants.DEPOSIT_FUNDS, method = RequestMethod.POST)
    public void depositFunds(@RequestBody UserDto userDto, @PathVariable Float deposit) {
        if ( deposit != 0 && !deposit.isNaN() ) {
            userService.depositFunds(userDto, deposit);
        } else {
            System.out.println("depositFunds received an invalid amount, NOT sending.");
        }
    }
}
