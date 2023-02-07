package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BingeScoreResponse;
import com.example.demo.entity.DailyStats;
import com.example.demo.entity.StreakTxn;
import com.example.demo.entity.WatchData;
import com.example.demo.repo.StreakTxnDataRepository;
import com.example.demo.repo.WatchDataRepository;

@Service
public class ServiceImpl {
	
	@Autowired
	StreakTxnDataRepository streakTxnDataRepository;
	

	@Autowired
  WatchDataRepository watchDataRepository;
	
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
	
	public BingeScoreResponse getDailyStats(String id) {
		List <WatchData> watchData=watchDataRepository.findAllByAccountId(id);
		
		List<DailyStats> dailyStatus =new ArrayList<>();
		
		BingeScoreResponse bingeScoreResponse =new BingeScoreResponse();
		
		if(watchData==null || watchData.size()==0)
			return null;
		
		Map<Date, List<WatchData>> map=watchData.stream()
		  .collect(Collectors.groupingBy(WatchData::getDateWatch));
		Long totalWatchDuration = 0L;
		 Long refSum=0L;
		  for (Map.Entry<Date, List<WatchData>> entry : map.entrySet()) {
			  Long sum=entry.getValue().stream().mapToLong(o -> o.getDuration()).sum();
			  refSum+=entry.getValue().stream().filter(val-> val.getRefId()!=null).mapToLong(o -> o.getDuration()).sum();

			  
			  DailyStats dailyStats =new DailyStats();
			  dailyStats.setDate(entry.getKey().getTime());
			  dailyStats.setDuration(sum);
			  dailyStatus.add(dailyStats);
			  
			  totalWatchDuration+=sum;
			  
		  }
		  
		  bingeScoreResponse.setDailyStats(dailyStatus);
		  bingeScoreResponse.setReedamable(true);
		  bingeScoreResponse.setRefDuration(refSum);
		  bingeScoreResponse.setTotalWatchDuration(totalWatchDuration);
		
		return bingeScoreResponse;
	}
}
