package com.ecom.app;

import java.util.List;

import com.ecom.app.entity.Account;
import com.ecom.app.repository.AccountDB;

public class TestClass {
	public static void main(String[] args) {
		
		AccountDB db = new AccountDB();
		
		List<Account> allAccounts = db.getAllAccounts();
		System.out.println(allAccounts);
		
		System.out.println("--------------------------------------");
		Account a = new Account();
		a.setAccountName("Varun");
		a.setAccountNumber(2);
		a.setBalance(3000);
		a.setIfscCode("ABC123");
		db.insertAccount(a);
		
		allAccounts = db.getAllAccounts();
		//System.out.println(allAccounts);
		Account a2 = new Account();
		a2.setAccountName("Neha");
		a2.setAccountNumber(3);
		a2.setBalance(13000);
		a2.setIfscCode("ABC123");
		db.insertAccount(a2);
		allAccounts = db.getAllAccounts();
		
		System.out.println("--------------------------------------");
		
		Account a3 = db.getAccountFromDB(2);
		System.out.println(a3);
		
		
	}
	
}
