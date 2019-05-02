package com.example.simpleatm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by vgerris on 19/4/19.
 * This represents a transaction of funds from an account
 */
@Entity
public class Transaction {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer transactionId;
    @Column
    private String transactionNote;
    @Column
    private Integer transactionAmount;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Atm atm;

    public Transaction(String transactionNote) {
        this.transactionNote = transactionNote;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNote() {
        return transactionNote;
    }

    public void setTransactionNote(String transactionNote) {
        this.transactionNote = transactionNote;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction() {
    }

    public Transaction(String transactionNote, Account account) {
        this.transactionNote = transactionNote;
        this.account = account;
    }
}
