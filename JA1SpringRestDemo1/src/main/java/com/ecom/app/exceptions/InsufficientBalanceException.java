package com.ecom.app.exceptions;

public class InsufficientBalanceException extends Exception{
	
	private int balance;
	
	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public InsufficientBalanceException(int balance) {
		super();
		this.balance = balance;
	}

	
	@Override
	public String toString() {
		return "Min Balance Should Be More Than 5000 , Current Balance "+balance;
	}
	
	

}
