package com.example.demo.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StreakTxn;
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
		WatchData dataS=null;
		if (data.getDuration() > TEN_MIN) {
			StreakTxn oldStreak = streakTxnDataRepository.getLatestScore(data.getAccountId());
			StreakTxn newStreak = new StreakTxn();

			Long prevScore = oldStreak.getNewScore();
			long minutes = (data.getDuration() / 1000) / 60;
			double newScore = prevScore + (minutes * 0.01);

			newStreak.setLastScore(prevScore);
			newStreak.setNewScore((long) newScore);
			newStreak.setAccountId(oldStreak.getAccountId());
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			newStreak.setLastDate(date);
			streakTxnDataRepository.save(newStreak);
			
			dataS = watchDataRepository.save(data);
			newStreak.setWatchId(dataS.getId() + "");
			newStreak.setAction("Streak");
			
			updateReffralBonus(data.getRefId(),dataS.getId());
			streakTxnDataRepository.save(newStreak);
		}
		return dataS;
	}

	private void updateReffralBonus(String updateAccountId, int watchId) {
		if (updateAccountId!=null) {
			StreakTxn refOldData = streakTxnDataRepository.getLatestScore(updateAccountId);
			StreakTxn newStreak = new StreakTxn();
			newStreak.setAction("Ref");
			newStreak.setAccountId(updateAccountId);
			newStreak.setLastScore(refOldData.getNewScore());
			newStreak.setNewScore(refOldData.getNewScore()+10);
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			newStreak.setLastDate(date);
			newStreak.setWatchId(watchId+"");
			streakTxnDataRepository.save(newStreak);			
		}
	}

}