package com.example.demo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StreakTxn;

@Repository
public interface StreakTxnDataRepository extends CrudRepository<StreakTxn, Integer> {
		
	@Query("from StreakTxn s where s.accountId =:id order by id desc limit 1 ")
	StreakTxn getLatestScore(String id);
  }