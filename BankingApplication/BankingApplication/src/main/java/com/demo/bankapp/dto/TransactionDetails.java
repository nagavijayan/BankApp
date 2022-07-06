package com.demo.bankapp.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

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
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
public class TransactionDetails {
private Long acctNum;
	
	
	@Temporal(TemporalType.TIME)
	private Date txDateTime;
	
	private String txType;
	
	private Double txAmount;

}
