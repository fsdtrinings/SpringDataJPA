package com.ecom.app.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.entity.Account;
import com.ecom.app.repository.AccountDB;
import com.ecom.app.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	IAccountRepository repository;
	
	@Override
	public boolean saveAccount(Account account) {
		repository.save(account);
		return true;
	}
	@Override
	public Account getAccountById(int accountNumber) {
		
		return repository.findById(accountNumber).get();
	}
	@Override
	public List<Account> getAllAccounts() {
	     List<Account> list = (List<Account>) repository.findAll();
	     return list;
	}
	@Override
	public boolean deleteAccountByID(int accountNumber) {
		repository.deleteById(accountNumber);
		return true;
	}
	
	@Override
	public boolean checkAccountByID(int accountNumber) {
		return repository.existsById(accountNumber);
	}
	@Override
	public List<Account> getAccountsByCity(String cityName)throws NoResultException 
	{
		return repository.getAccountsByCity(cityName);
	}
	
	
	
}

