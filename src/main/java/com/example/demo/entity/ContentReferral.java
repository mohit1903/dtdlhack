package com.example.demo.entity;

import java.sql.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contentReferral")
public class ContentReferral {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    
	String accountId;
	
    String code;

	int contentId;
	
	Date referralDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContentReferral(Integer id, String accountId, String code, int contentId, Date referralDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.code = code;
		this.contentId = contentId;
		this.referralDate = referralDate;
	}
	
	public ContentReferral() {
		super();
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public Date getReferralDate() {
		return referralDate;
	}

	public void setReferralDate(Date referralDate) {
		this.referralDate = referralDate;
	}

}
