package com.ecom.app.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String houseNumber;
	private String cityName;
	private String state;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String houseNumber, String cityName, String state) {
		super();
		this.houseNumber = houseNumber;
		this.cityName = cityName;
		this.state = state;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	

}
