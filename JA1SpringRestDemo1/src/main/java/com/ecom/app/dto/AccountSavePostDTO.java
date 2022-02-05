package com.ecom.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccountSavePostDTO {

	@NotNull(message = "Name is empty")
	private String accountName;
	@Min(value = 5000,message = "Min balance is 5000")
	private int balance;
	public AccountSavePostDTO(@NotNull(message = "Name is empty") String accountName,
			@Min(value = 5000, message = "Min balance is 5000") int balance) {
		super();
		this.accountName = accountName;
		this.balance = balance;
	}
	public AccountSavePostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
