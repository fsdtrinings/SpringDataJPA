package com.ecom.app.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.AccountOnwerBasicInfoDTO;
import com.ecom.app.dto.AccountSavePostDTO;
import com.ecom.app.entity.Account;
import com.ecom.app.entity.Policy;
import com.ecom.app.repository.AccountDB;
import com.ecom.app.repository.IAccountRepository;
import com.ecom.app.repository.IPolicyRepository;
import com.ecom.app.util.AccountDTOConvertionClass;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	IAccountRepository repository;
	
	@Autowired
	IPolicyRepository policyRepository;
	
	
	@Autowired
	AccountDTOConvertionClass dtoConvertion;
	
	@Override
	public AccountOnwerBasicInfoDTO saveAccount(AccountSavePostDTO accountDto) {
		
		Account a = dtoConvertion.getAccountFromPostAccountDTO(accountDto);
		
		Account savedObj  = repository.save(a);
		AccountOnwerBasicInfoDTO dtoObj = dtoConvertion.getAccountOwnerBasicDTO(savedObj);
		return dtoObj;
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
	@Override
	@Transactional
	public boolean addPolicy(int accountNumber,int policyId) {
		
		Policy p = policyRepository.findById(policyId).get();
		Account account = getAccountById(accountNumber);
		if(account!=null && p!= null)
		{
			List<Policy> policies = account.getPolicies();
			policies.add(p);
			account.setPolicies(policies);
		}
		
		repository.save(account);
		
		return true;
				
	}

	
	
	
}











