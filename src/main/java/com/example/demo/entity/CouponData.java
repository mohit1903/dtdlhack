package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="couponData")
public class CouponData {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    
	String accountId;
    
    String couponType;
    
    String couponCode;

	int value;
	
	boolean isActive;

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

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CouponData() {
		super();
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public CouponData(Integer id, String accountId, String couponType, String couponCode, int value, boolean isActive) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.couponType = couponType;
		this.couponCode = couponCode;
		this.value = value;
		this.isActive = isActive;
	}

}
