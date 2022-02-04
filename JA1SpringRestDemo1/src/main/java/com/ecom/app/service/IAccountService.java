package com.ecom.app.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;

import com.ecom.app.entity.Account;

@Service
public interface IAccountService {

	public boolean saveAccount(Account account);
	public Account getAccountById(int accountNumber);
	public List<Account> getAllAccounts();
	public boolean deleteAccountByID(int accountNumber);
	public boolean checkAccountByID(int accountNumber);
	
	public List<Account> getAccountsByCity(String cityName)throws NoResultException;
}
