package com.ecom.app.dto;

public class AccountOwnerFundTransferDTO {
	private int accountNumber;
	private int currentBalance;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
	public AccountOwnerFundTransferDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountOwnerFundTransferDTO(int accountNumber, int currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
	}
	
	/*
	 * or we can add Transaction information like 
	 * 
	 * private Transaction t;
	 * */
	
	
	
}
