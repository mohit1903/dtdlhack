package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StreakTxn;
import com.example.demo.repo.StreakTxnDataRepository;

@Service
public class ServiceImpl {
	
	@Autowired
	StreakTxnDataRepository streakTxnDataRepository;
	
	public StreakTxn getStreakScoreAndBreak(String id) {
		
		StreakTxn txn = streakTxnDataRepository.getLatestScore(id);
		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currDate = dateObj.format(formatter);
		Date date = Date.valueOf(currDate);
		if(txn==null) {
			txn.setAccountId(id);
			txn.setAction("Create");
			txn.setLastDate(date);
			txn.setLastScore((long)0);
			txn.setNewScore((long) 0);
			return 	streakTxnDataRepository.save(txn);
		}

		Date oneDayBefore = new Date(date.getTime() - 2);

		StreakTxn newTxn = new StreakTxn();

		if (txn.getLastDate().equals(oneDayBefore) || txn.getLastDate().equals(date)  ) {
			return txn ;

		} else {
			newTxn.setAccountId(id);
			newTxn.setLastScore(txn.getNewScore());
			newTxn.setNewScore(txn.getNewScore() / 2);
			newTxn.setAction("Streak Break");
			newTxn.setWatchId(null);
			newTxn.setLastDate(date);
			streakTxnDataRepository.save(newTxn);

		}

		return newTxn;

	}
}
