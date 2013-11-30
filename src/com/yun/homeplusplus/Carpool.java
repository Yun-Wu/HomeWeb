package com.yun.homeplusplus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Carpool implements Comparable<Carpool> {
	
	@Id
	private Long id;
	private Long apartmentId;
	private Long userId;

	
	
	private String carOwnner;
	private String start;
	private String destination;
	private String make;
	private String model;
	private Integer space;
	
	private Date createDate;
	private Date takeplaceDate;
	
	
	private String date;
	private String time;
	private String message;
	
	private List<Long> participantsId;
	private String coverUrl;
	
	
	// construct
	
	public Carpool(Long apartmentId, Long userId, String carOwnner, String start, String destination, String message,
					String date, String time, String make, String model, Integer space, String coverUrl){
		
		
		this.apartmentId = apartmentId;
		this.userId = userId;
		this.carOwnner = carOwnner;
		this.start = start;
		this.destination = destination;
		this.message = message;
		this.coverUrl = coverUrl;
		
		this.make = make;
		this.model = model;
		this.space = space;
		
		this.date=date;
		this.time=time;
		
		String[] dateString = date.split("/");
		String[] timeString = time.split(":");
		
		createDate = new Date();
		takeplaceDate = new Date();
		
		
		//  notice the math relationship
		
		takeplaceDate.setYear(new Integer(dateString[2]));
		takeplaceDate.setMonth(new Integer(dateString[1]));
		takeplaceDate.setDate(new Integer(dateString[0]));
		
		takeplaceDate.setHours(new Integer(timeString[0]));
		takeplaceDate.setMinutes(new Integer(timeString[1]));
		
		participantsId = new ArrayList<Long>();
		
		
		
	}
	
	private Carpool(){
		
	}
	
	public void signUp(Long userId){
		
		participantsId.add(userId);
		
	}
	
	public void cancelSignUp(Long userId){
		
		participantsId.remove(userId);
		
	}
	
	public List<Long> getParticipantsList(){
		
		return participantsId;
	}
	
	public String getCoverUrl(){
		return coverUrl;
	}
	
	public Long getApartmentId(){
		return apartmentId;
	}

	@Override
	public int compareTo(Carpool another) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}