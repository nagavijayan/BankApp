package com.demo.bankapp.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.bankapp.dto.AccountDetails;
import com.demo.bankapp.dto.TransactionDetails;
import com.demo.bankapp.dto.TransferDetails;
import com.demo.bankapp.model.Accounts;
import com.demo.bankapp.model.Transactions;
import com.demo.bankapp.repository.AccountRepo;
import com.demo.bankapp.repository.TransactionRepo;
import com.demo.bankapp.service.BankingService;
import com.demo.bankapp.service.Helper.BankingServiceHelper;

public class BankingServiceImpl implements BankingService {
	
	@Autowired
	private AccountRepo aRepo;
	@Autowired
	private TransactionRepo tranRepo;
	@Autowired
	private BankingServiceHelper bankingServiceHelper;
	
	public BankingServiceImpl(AccountRepo repo) {
		this.aRepo= repo;
	}
	
	public List<AccountDetails> findAll(){
		List<AccountDetails> allAccountDetails = new ArrayList<>();

        Iterable<Accounts> accountList = aRepo.findAll();

        accountList.forEach(account -> {
        	allAccountDetails.add(bankingServiceHelper.convertToAccountsdomain(account));
        });
        
        return allAccountDetails;
    }
	/*Find by AccountNumber
	 * 
	 */
public ResponseEntity<Object> findByAcctNum(Long acctNum) {
		
		Optional<Accounts> accountEntityOpt = Optional.ofNullable(aRepo.findbyAcctNum(acctNum));

		if(accountEntityOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body(bankingServiceHelper.convertToAccountsdomain(accountEntityOpt.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Number " + acctNum + " not found.");
		}
		
	}

/**
 * Get all transactions for a specific account
 * 
 * @param accountNumber
 * @return
 */
public List<TransactionDetails> findTransactionsByAcctNum(Long acctNum) {
	List<TransactionDetails> transactionDetails = new ArrayList<>();
	Optional<Accounts> accountEntityOpt = Optional.of(aRepo.findbyAcctNum(acctNum));
	if(accountEntityOpt.isPresent()) {
		Optional<List<Transactions>> transactionEntitiesOpt =tranRepo.findByAcctNum(acctNum);
		if(transactionEntitiesOpt.isPresent()) {
			transactionEntitiesOpt.get().forEach(transaction -> {
				transactionDetails.add(bankingServiceHelper.convertToTransactiondomain(transaction));
			});
		}
	}
	
	return transactionDetails;
}

@Override
public ResponseEntity<Object> addAccounts(AccountDetails accountDetails) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long acctNum) {
	List<Accounts> accountEntities = new ArrayList<>();
	Accounts fromAccountEntity = null;
	Accounts toAccountEntity = null;
	
	Optional<Accounts> accountEntityOpt = Optional.of(aRepo.findbyAcctNum(acctNum));
	
	// If Account is present
			if(accountEntityOpt.isPresent()) {
		
			
    // get FROM ACCOUNT info
	Optional<Accounts> fromAccountEntityOpt = Optional.ofNullable(aRepo.findbyAcctNum(transferDetails.getFromAccountNumber()));
	if(fromAccountEntityOpt.isPresent()) {
		fromAccountEntity = fromAccountEntityOpt.get();
	}
	else {
	// if from request does not exist, 404 Bad Request
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("From Account Number " + transferDetails.getFromAccountNumber() + " not found.");
	}
	// get TO ACCOUNT info
				Optional<Accounts> toAccountEntityOpt = Optional.of(aRepo.findbyAcctNum(transferDetails.getToAccountNumber()));
				if(toAccountEntityOpt.isPresent()) {
					toAccountEntity = toAccountEntityOpt.get();
				}
				else {
				// if from request does not exist, 404 Bad Request
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("To Account Number " + transferDetails.getToAccountNumber() + " not found.");
				}

				
				// if not sufficient funds, return 400 Bad Request
				if(fromAccountEntity.getAccountBalance() < transferDetails.getTransferAmount()) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient Funds.");
				}
				else {
					synchronized (this) {
						// update FROM ACCOUNT 
						fromAccountEntity.setAccountBalance(fromAccountEntity.getAccountBalance() - transferDetails.getTransferAmount());
						//((Date) fromAccountEntity).setUpdateDateTime(new Date());
						accountEntities.add(fromAccountEntity);
						
						// update TO ACCOUNT
						toAccountEntity.setAccountBalance(toAccountEntity.getAccountBalance() + transferDetails.getTransferAmount());
						//toAccountEntity.setUpdateDateTime(new Date());
						accountEntities.add(toAccountEntity);
						
						aRepo.saveAll(accountEntities);
						
						// Create transaction for FROM Account
						Transactions fromTransaction = bankingServiceHelper.createTransaction(transferDetails, fromAccountEntity.getAcctNum(), "DEBIT");
						tranRepo.save(fromTransaction);
						
						// Create transaction for TO Account
						Transactions toTransaction = bankingServiceHelper.createTransaction(transferDetails, toAccountEntity.getAcctNum(), "CREDIT");
						tranRepo.save(toTransaction);
					}

					return ResponseEntity.status(HttpStatus.OK).body("Success: Amount transferred for Account Number " + acctNum);
				
			}
				}
				else{                                                
		
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Number " + acctNum + " not found.");
			}

	
	
}
}



		
	


