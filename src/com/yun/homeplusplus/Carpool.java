package com.yun.homeplusplus;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity

public class Carpool {
	
	@Id
	private Long id;
	private Long apartmentId;
	private Long userId;
	
	
	private String carOwnner;
	private String start;
	private String destination;
	
	private Date createDate;
	
	private String year;
	private String month;
	private String date;
	private String time;
	private String message;
	
	
	// construct
	private Carpool(){}
	
	public Carpool(Long apartmentId, Long userId, String carOwnner, String start, String destination, String message,
					String year, String month, String date, String time){
		
		
		this.apartmentId = apartmentId;
		this.userId = userId;
		this.carOwnner = carOwnner;
		this.start = start;
		this.destination = destination;
		this.message = message;
		
		this.year = year;
		this.month = month;
		this.date = date;
		this.time = time;
		
		createDate = new Date();
		
		
	}
	
	

}
