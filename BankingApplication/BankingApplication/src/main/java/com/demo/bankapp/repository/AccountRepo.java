package com.demo.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankapp.model.Accounts;


@Repository

public interface AccountRepo extends JpaRepository<Accounts,Integer>{

	

	Accounts findbyAcctNum(Long id);
	
	//@Query("select * from accounts where accountBalance>0")
	//public int findAccontBalance by id(int id);
	
	/*@Query("select * from accounts where mab>1000")
	public int findacconts by mab(int mab);*/

	

}
