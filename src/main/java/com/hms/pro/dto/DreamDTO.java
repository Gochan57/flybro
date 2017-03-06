package com.hms.pro.dto;

import java.sql.Date;

import com.hms.pro.model.Dream;


public class DreamDTO{
	private int id;
	private double altitude;
	private double longitude;		
	private Date date;	
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Dream castToDream(DreamDTO dto) {
		Dream dream = new Dream();
		dream.setId(dto.getId());
		dream.setDate(dto.getDate());
		dream.setAltitude(dto.getAltitude());
		dream.setLongitude(dto.getLongitude());
		dream.setUserId(dto.getUserId());
		return dream;
	}
	
}