package com.example.demo.entity;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StreakTransaction")
public class StreakTxn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String accountId;
	String action;
	Long lastScore;
	Long newScore;
	String watchId;
	Date lastDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getLastScore() {
		return lastScore;
	}

	public void setLastScore(Long lastScore) {
		this.lastScore = lastScore;
	}

	public Long getNewScore() {
		return newScore;
	}

	public void setNewScore(Long newScore) {
		this.newScore = newScore;
	}

	public String getWatchId() {
		return watchId;
	}

	public void setWatchId(String watchId) {
		this.watchId = watchId;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, action, id, lastDate, lastScore, newScore, watchId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StreakTxn other = (StreakTxn) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(action, other.action)
				&& Objects.equals(id, other.id) && Objects.equals(lastDate, other.lastDate)
				&& Objects.equals(lastScore, other.lastScore) && Objects.equals(newScore, other.newScore)
				&& Objects.equals(watchId, other.watchId);
	}
	
	public StreakTxn(Integer id, String accountId, String action, Long lastScore, Long newScore, String watchId,
			Date lastDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.action = action;
		this.lastScore = lastScore;
		this.newScore = newScore;
		this.watchId = watchId;
		this.lastDate = lastDate;
	}
	
	public StreakTxn() {
	}


}
