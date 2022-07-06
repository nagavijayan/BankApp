package com.demo.bankapp.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.bankapp.dto.AccountDetails;
import com.demo.bankapp.model.Accounts;
import com.demo.bankapp.repository.AccountRepo;


@Service

//@Component
public class AccountService {
	@Autowired
	private AccountRepo aRepo;
	
	public Accounts saveAccounts(AccountDetails accountDetails) {
		Accounts account=Accounts.build(0, 0, accountDetails.getCustomerName(),
				accountDetails.getTaxID(), accountDetails.getDob(), accountDetails.getAge(), 
				accountDetails.getAccountType(), accountDetails.getAccountStatus(), accountDetails.getAccountBalance(),
				accountDetails.getPhoneNum(), accountDetails.getEmailId(), accountDetails.getMab());
		return aRepo.save(account);
		
	}
	
	public List<Accounts>getAllAccounts(){
		return aRepo.findAll();
	}
	
	public Accounts getAccounts(Long id) throws AccountNotFoundException {
		Accounts account=aRepo.findbyAcctNum(id);
		if(account!=null) {
			return account;
		}else {;
			throw new AccountNotFoundException("Account not Found with" +id);
		}
		
	}



}