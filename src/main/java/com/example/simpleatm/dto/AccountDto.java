package com.example.simpleatm.dto;

/**
 * Created by vgerris on 21/4/19.
 */
public class AccountDto {
    Integer accountId;
    String accountName;
    Float balance;

    public AccountDto(Integer accountId, String accountName, Float balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public AccountDto() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void addBalance(Float amount) {
        balance = balance + amount;
    }

    public void removeBalance(Float amount) {
        balance = balance - amount;
    }

}
