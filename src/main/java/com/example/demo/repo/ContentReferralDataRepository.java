package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ContentReferral;

@Repository
public interface ContentReferralDataRepository extends CrudRepository<ContentReferral, Integer> {
		
  }