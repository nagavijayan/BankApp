package com.demo.bankapp.service.Helper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.demo.bankapp.dto.AccountDetails;
import com.demo.bankapp.dto.TransactionDetails;
import com.demo.bankapp.dto.TransferDetails;
import com.demo.bankapp.model.Accounts;
import com.demo.bankapp.model.Transactions;
@Component
public class BankingServiceHelper {
	
	public AccountDetails convertToAccountsdomain(Accounts account) {
		return AccountDetails.builder()
				.customerName(account.getCustomerName())
				.taxID(account.getTaxID())
				.dob(account.getDob())
				.age(account.getAge())
				.accountType(account.getAccountType())
				.accountStatus(account.getAccountStatus())
				.accountBalance(account.getAccountBalance())
				.phoneNum(account.getPhoneNum())
				.emailId(account.getEmailId())
				.mab(account.getMab())
				.build();
				
	}
	
	public Accounts convertToAccountsEntity(AccountDetails accountDetails) {
		return Accounts.builder()
				.customerName(accountDetails.getCustomerName())
				.taxID(accountDetails.getTaxID())
				.dob(accountDetails.getDob())
				.age(accountDetails.getAge())
				.accountType(accountDetails.getAccountType())
				.accountStatus(accountDetails.getAccountStatus())
				.accountBalance(accountDetails.getAccountBalance())
				.phoneNum(accountDetails.getPhoneNum())
				.emailId(accountDetails.getEmailId())
				.mab(accountDetails.getMab())
				.build();
				
	}
	
	public TransactionDetails convertToTransactiondomain(Transactions transaction) {
		return TransactionDetails.builder()
				.acctNum(transaction.getAcctNum())
				.txDateTime(transaction.getTxDateTime())
				.txType(transaction.getTxType())
				.txAmount(transaction.getTxAmount())
				.build();	
		}
	public Transactions convertToTransactionsEntity(TransactionDetails transactionDetails) {
		return Transactions.builder()
				.acctNum(transactionDetails.getAcctNum())
				.txDateTime(transactionDetails.getTxDateTime())
				.txType(transactionDetails.getTxType())
				.txAmount(transactionDetails.getTxAmount())
				.build();
	}
	
	public Transactions createTransaction(TransferDetails transferDetails, Long acctNum, String txType) {
		return Transactions.builder()
				.acctNum(acctNum)
				.txAmount(transferDetails.getTransferAmount())
				.txType(txType)
				.txDateTime(new Date())
				.build();
		
	}

}
