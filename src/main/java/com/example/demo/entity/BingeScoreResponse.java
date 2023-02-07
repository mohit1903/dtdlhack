package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BingeScoreResponse {
	@JsonProperty("dailyStats")
	private List<DailyStats> dailyStats;
	private Long totalWatchDuration;
	private Long refDuration;
	
	private boolean reedamable;

	public List<DailyStats> getDailyStats() {
		return dailyStats;
	}

	public void setDailyStats(List<DailyStats> dailyStats) {
		this.dailyStats = dailyStats;
	}

	public Long getTotalWatchDuration() {
		return totalWatchDuration;
	}

	public void setTotalWatchDuration(Long totalWatchDuration) {
		this.totalWatchDuration = totalWatchDuration;
	}

	public Long getRefDuration() {
		return refDuration;
	}

	public void setRefDuration(Long refDuration) {
		this.refDuration = refDuration;
	}

	public boolean isReedamable() {
		return reedamable;
	}

	public void setReedamable(boolean reedamable) {
		this.reedamable = reedamable;
	}
	
	
	
	

}
