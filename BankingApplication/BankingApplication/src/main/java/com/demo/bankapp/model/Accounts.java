package com.demo.bankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Account_Details")
@Data
@Builder
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class Accounts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		
		//private long account_Id;
	@Column(name="ACCT_ID")
	    private int id;
	
	    @NotNull
	    @Column(name="Account_Number")
	    private long acctNum;
	
	    @NotNull
	    @Column(name="Customer_Name")
		private String customerName;
	    
	    @NotNull
	    @Column(name="Tax_ID")
		private String taxID;
	    
	    @Column(name="Data_Of_Birth")
	    @Pattern(regexp="DD/mm/yyyy")
		private int dob;
	    
	    @Max(60)
	    @Min(18)
	    @Column(name="Age")
	    private int age;
	    
	    @Column(name="Account_Type")
	    @NotNull(message="should be savings or current or salary")
		private String accountType;
	    
	    @Column(name="Account_Status")
	    @NotNull(message="should be Active or NON-Active")
		private String accountStatus;
	    
	    @NotBlank
	    @Column(name="Account_Balance")
		private double accountBalance;
	    
	    @Column(name="Phone_Num")
	    @Pattern(regexp="^//d{10)$",message="phone number must be 10 digits")
		private long phoneNum;
	    
	    @Email(message="Invalid email")
		private String emailId;
	    
	    @NotNull
		private int mab;
		


}
