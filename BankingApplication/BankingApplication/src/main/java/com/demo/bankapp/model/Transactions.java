package com.demo.bankapp.model;

import java.util.Date;
//import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Transactions")
@Data
@Builder
@AllArgsConstructor(staticName="Build")
@NoArgsConstructor
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TX_ID")
	private int id;
	
	private long acctNum;
	
	
	@Temporal(TemporalType.TIME)
	private Date txDateTime;
	
	private String txType;
	
	private double txAmount;

	
}


