package com.demo.bankapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.bankapp.dto.AccountDetails;
import com.demo.bankapp.dto.TransactionDetails;
import com.demo.bankapp.dto.TransferDetails;

public interface BankingService {
	
	public List<AccountDetails> findAll();
	
    public ResponseEntity<Object> addAccounts(AccountDetails accountDetails);
	
	public ResponseEntity<Object> findByAcctNum(Long acctNum);
	
	 public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long acctNum);
	    
	 public List<TransactionDetails> findTransactionsByAcctNum(Long acctNum);
	    

}
