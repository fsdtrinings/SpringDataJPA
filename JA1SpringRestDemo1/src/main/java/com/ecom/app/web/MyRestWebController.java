package com.ecom.app.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.app.entity.Account;
import com.ecom.app.entity.Policy;
import com.ecom.app.exceptions.InsufficientBalanceException;
import com.ecom.app.exceptions.InvalidIFSCCodeException;
import com.ecom.app.service.IAccountService;

@RestController
@RequestMapping("/app")
public class MyRestWebController {

	@Autowired
	IAccountService service;
	
	@GetMapping("/account/{accountNumber}")
	public Account getAccountInfo(@PathVariable int accountNumber)
	{
		return service.getAccountById(accountNumber);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return service.getAllAccounts();
	}
	
	@PostMapping("/account")
	public boolean saveAccount(@RequestBody Account a)
			 throws InsufficientBalanceException,InvalidIFSCCodeException
	{
		if(a.getBalance()<5000)
		{
			throw new InsufficientBalanceException(a.getBalance());
		}
		else service.saveAccount(a);
		return true;
	}
	
	@GetMapping("/accountslist")
	public List<Account> getAllAccounts(@RequestParam String city)
	{
		return service.getAccountsByCity(city);
	}

	//  localhost:8090:/app/accountslist?city=delhi
	 
	
	@PostMapping("/policy")
	public ResponseEntity<Boolean> addPolicy(@RequestParam int policyId ,@RequestParam int id)
	{
		boolean a = service.addPolicy(id, policyId);
		return new ResponseEntity<Boolean>(a, HttpStatus.OK);
	}
	
}//end class













