package com.example.simpleatm.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashish on 13/5/17.
 */
public class UserDto {
    Integer userId;
    String userName;
    List<AccountDto> accountDtos= new ArrayList<>();

    public UserDto(Integer userId, String userName, List<AccountDto> accountDtos) {
        this.userId = userId;
        this.userName = userName;
        this.accountDtos = accountDtos;
    }

    public UserDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<AccountDto> getAccountDtos() {
        return accountDtos;
    }

    public void setAccountDtos(List<AccountDto> accountDtos) {
        this.accountDtos = accountDtos;
    }
}
