package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.WatchData;

@Repository
public interface WatchDataRepository extends CrudRepository<WatchData, Integer> {

	
	@Query("FROM WatchData where accountId =:id and refId is not null")
	List<WatchData> getReferralData(String id);
		
  }