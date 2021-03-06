package com.ecom.app.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;

import com.ecom.app.dto.AccountOnwerBasicInfoDTO;
import com.ecom.app.dto.AccountSavePostDTO;
import com.ecom.app.entity.Account;
import com.ecom.app.entity.Policy;

@Service
public interface IAccountService {

	public AccountOnwerBasicInfoDTO saveAccount(AccountSavePostDTO account);
	public Account getAccountById(int accountNumber);
	public List<Account> getAllAccounts();
	public boolean deleteAccountByID(int accountNumber);
	public boolean checkAccountByID(int accountNumber);
	
	public List<Account> getAccountsByCity(String cityName)throws NoResultException;
	public boolean addPolicy(int accountNumber,int policyId);
}
