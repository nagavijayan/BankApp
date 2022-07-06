package com.demo.bankapp.dto;



import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetails {
	
    private long fromAccountNumber;
	
	private long toAccountNumber;
	
	private double transferAmount;
	
	//@Temporal(TemporalType.TIME)
	//private Date transDateTime;

}
