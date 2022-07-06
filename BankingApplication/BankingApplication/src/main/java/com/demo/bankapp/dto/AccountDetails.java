package com.demo.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@Builder
@AllArgsConstructor(staticName="build")
@NoArgsConstructor


public class AccountDetails {
	
	private String customerName;
    
	private String taxID;
 
    
	private int dob;
	
	private int age;
	
	private String accountType;
	
	private String accountStatus;
	
	private double accountBalance;
	
	private long phoneNum;
	
	private String emailId;
	
	private int mab;

}
