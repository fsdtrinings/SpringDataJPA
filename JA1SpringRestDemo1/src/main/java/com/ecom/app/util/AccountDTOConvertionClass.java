package com.ecom.app.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.ecom.app.dto.AccountOnwerBasicInfoDTO;
import com.ecom.app.dto.AccountOwnerFundTransferDTO;
import com.ecom.app.dto.AccountSavePostDTO;
import com.ecom.app.entity.Account;

@Component
public class AccountDTOConvertionClass {
	
		public AccountOnwerBasicInfoDTO getAccountOwnerBasicDTO(Account account)
		{
			AccountOnwerBasicInfoDTO dtoObj = new AccountOnwerBasicInfoDTO();
			dtoObj.setAccountNumber(account.getAccountNumber());
			dtoObj.setAccountHolderName(account.getAccountName());
			dtoObj.setBalance(account.getBalance());
			dtoObj.setCommunicationId(new Random().nextInt(8500));
			
			return dtoObj;
		}
		
		public AccountOwnerFundTransferDTO getAccountOwnerFundTransfer(Account a)
		{
			AccountOwnerFundTransferDTO ftDto = new AccountOwnerFundTransferDTO();
			ftDto.setAccountNumber(a.getAccountNumber());
			ftDto.setCurrentBalance(a.getBalance());
			
			return ftDto;
		}
		
		public Account getAccountFromPostAccountDTO(AccountSavePostDTO dto)
		{
			Account a = new Account();
			a.setAccountName(dto.getAccountName());
			a.setBalance(dto.getBalance());
			
			return a;
		}
		

}
