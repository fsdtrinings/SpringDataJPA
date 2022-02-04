package com.ecom.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecom.app.entity.Account;

@Repository
public interface CustomAccountRepository {
	public List<Account> getAccountsByCity(String cityName);
	
	
	/*
	 *  public boolean addPolicy(int accountNumber,Policy p)
	 * 
	 * 
	 * */
}
