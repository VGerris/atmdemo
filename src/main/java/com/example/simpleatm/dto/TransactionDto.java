package com.example.simpleatm.dto;

public class TransactionDto {
    Integer transactionId;
    String transactionName;

    public TransactionDto(Integer transactionId, String transactionName) {
        this.transactionId = transactionId;
        this.transactionName=transactionName;
    }

    public TransactionDto() {
    }
}
