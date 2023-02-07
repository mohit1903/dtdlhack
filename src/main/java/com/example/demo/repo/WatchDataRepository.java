package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.WatchData;

@Repository
public interface WatchDataRepository extends CrudRepository<WatchData, Integer> {

  }