package com.demo.bankapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bankapp.model.Transactions;


@Repository
public interface TransactionRepo extends JpaRepository<Transactions,Integer> {
	 public Optional<List<Transactions>> findByAcctNum(Long acctNum);
}
