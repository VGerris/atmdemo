package com.example.simpleatm.utils;

public interface Constants {

	static final String GET_USER_BY_ID = "/getUser/{userId}";
	static final String GET_ALL_USERS = "/getAllUsers";
	static final String SAVE_USER = "/saveUser";
	static final String SAVE_USER_BALANCE = "/saveUserBalance";
	static final String WITHDRAW_FUNDS = "/withdrawFunds/{withdraw}";
	static final String DEPOSIT_FUNDS = "/depositFunds/{deposit}";

	static final String GET_ATM_BY_ID = "/getAtm/{atmId}";
	static final String GET_ALL_ATMS = "/getAllAtms";
	static final String SAVE_ATM = "/saveAtm";
	static final String WITHDRAW_BILLS = "/withdrawBills/{withdraw}";
	static final String DEPOSIT_BILLS = "/depositBills/{deposit20}/{deposit50}/{deposit100}/{deposit200}/{deposit500}/{deposit1000}";

}
