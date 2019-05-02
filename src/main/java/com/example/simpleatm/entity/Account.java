
package com.example.simpleatm.entity;

import javax.persistence.*;

/**
 * Created by vgerris on 19/4/19.
 */
@Entity
public class Account {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer accountId;
    @Column
    private String accountName;
    @Column
    private Float balance;
    @ManyToOne
    private User user;

    public Account() {
    }

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public Account(String accountName, User user, Float balance) {
        this.accountName = accountName;
        this.user = user;
        this.balance = balance;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

}
