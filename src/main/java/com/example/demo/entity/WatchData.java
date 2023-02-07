package com.example.demo.entity;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import jakarta.persistent.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name="watchData")
public class WatchData {
    
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    
	String accountId;
    
    String contentType;
    
    long duration;

	Date dateWatch;
    
    public WatchData(int id, String accountId, String contentType, long duration, Date dateWatch, String refId,
			boolean isRedeemed, String coupon, String link) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.contentType = contentType;
		this.duration = duration;
		this.dateWatch = dateWatch;
		this.refId = refId;
		this.isRedeemed = isRedeemed;
		this.coupon = coupon;
		this.link = link;
	}

	String refId;
    
    boolean isRedeemed;
    
    String coupon;
    
    String link;
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Date getDateWatch() {
		return dateWatch;
	}

	public void setDateWatch(Date dateWatch) {
		this.dateWatch = dateWatch;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public boolean isRedeemed() {
		return isRedeemed;
	}

	public void setRedeemed(boolean isRedeemed) {
		this.isRedeemed = isRedeemed;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
    
    
   
    


}
