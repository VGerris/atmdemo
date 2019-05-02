package com.example.simpleatm.converter;

import com.example.simpleatm.dto.AccountDto;
import com.example.simpleatm.entity.Account;

/**
 * Created by vgerris on 21/4/19.
 */
public class AccountConverter {

    public static Account dtoToEntity(AccountDto AccountDto) {
        Account Account = new Account(AccountDto.getAccountName(), null, null);
        Account.setAccountId(AccountDto.getAccountId());
        Account.setBalance(AccountDto.getBalance());
        return Account;
    }

    public static AccountDto entityToDto(Account account) {
        return new AccountDto(account.getAccountId(), account.getAccountName(), account.getBalance());
    }
}
