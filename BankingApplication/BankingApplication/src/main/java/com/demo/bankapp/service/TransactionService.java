package com.demo.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bankapp.dto.TransactionDetails;
import com.demo.bankapp.model.Transactions;
import com.demo.bankapp.repository.TransactionRepo;
@Service
public class TransactionService {
	@Autowired
	private TransactionRepo transRepo;
	
	public Transactions saveTransactions(TransactionDetails tranDetails) {
		
		Transactions trans= Transactions.Build(0, tranDetails.getAcctNum(), 
				 tranDetails.getTxDateTime(),tranDetails.getTxType(), tranDetails.getTxAmount());
	   return transRepo.save(trans)	;
	}

}
