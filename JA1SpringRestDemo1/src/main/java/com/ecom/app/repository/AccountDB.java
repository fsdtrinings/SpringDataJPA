package com.ecom.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ecom.app.entity.Account;


public class AccountDB {
	
	List<Account> list = new ArrayList<>();
	
	public AccountDB() {
		Account a = new Account();
		a.setAccountName("Ramesh");
		a.setAccountNumber(1);
		a.setBalance(2000);
		a.setIfscCode("ABC123");
		
		Account a2 = new Account();
		a2.setAccountName("Neha");
		a2.setAccountNumber(2);
		a2.setBalance(13000);
		a2.setIfscCode("ABC123");
		
		list.add(a);
		list.add(a2);
		
	}
	
	public void insertAccount(Account a)
	{
		list.add(a);
	}
	
	public Account getAccountFromDB(long searchAccountNumber)
	{
		Account result = null;
		result = list.stream().filter((a)->{
			if(a.getAccountNumber() == searchAccountNumber)
			{
				return true;
			}
			else {
				return false;
			}
		}).collect(Collectors.toList()).get(0);
		
		return result;
	}

	public List<Account> getAllAccounts()
	{
		return list;
	}
}
