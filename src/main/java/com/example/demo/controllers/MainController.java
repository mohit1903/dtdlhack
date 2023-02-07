package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.WatchData;
import com.example.demo.repo.StreakTxnDataRepository;
import com.example.demo.repo.WatchDataRepository;
import com.example.service.Service;

@RestController
public class MainController {

	
	private static final int TEN_MIN = 600000;
	
	@Autowired
	WatchDataRepository watchDataRepository;
	
	@Autowired
	StreakTxnDataRepository streakTxnDataRepository;
	
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
    @PostMapping("/WatchEntry")
    public WatchData createUser(@RequestBody WatchData data) {
      
    	if(data.getDuration()>TEN_MIN) {
//    		if(streakTxnDataRepository.getLatestScore())
    		streakTxnDataRepository.getLatestScore("1");
    	}
    	
        return watchDataRepository.save(data);
    }

}