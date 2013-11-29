package com.yun.homeplusplus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Sports implements Comparable<Sports> {
	
	@Id
	private Long id;
	private Long initiatorId;
	private String initiator;
	private Long apartmentId;
	
	private List<Long> participantId;
	private String activity;
	private Date takeplaceDate;
	private String time;
	private String date;
	private String message;
	private String location;
	private String coverUrl;
	
	public Sports(Long apartmentId, Long initiatorId, String initiator, String activity, String message, String location,
					String time, String date, String coverUrl){
		
		this.apartmentId=apartmentId;
		this.initiator = initiator;
		this.initiatorId=initiatorId;
		this.activity=activity;
		this.message=message;
		this.location=location;
		this.time=time;
		this.date=date;
		this.coverUrl = coverUrl;
		
		
		participantId = new ArrayList<Long>();
		
		takeplaceDate = new Date();
		String[] timeString = time.split(":");
		String[] dateString = date.split("/");
		
		//test it's ok for new Integer("01");
		//maybe some bug with set year.. + 1900
		
		takeplaceDate.setDate(new Integer(dateString[0]) );
		takeplaceDate.setMonth(new Integer(dateString[1]));
		takeplaceDate.setYear(new Integer(dateString[2]));   /*1900???*/
		
		takeplaceDate.setHours(new Integer(timeString[0]));
		takeplaceDate.setMinutes(new Integer(timeString[1]));
		
	
	}
	
	public void signUp(Long userId){
		
		participantId.add(userId);
		
	}
	
	public void cancelSignUp(Long userId){
		
		participantId.remove(userId);
		
	}
	
	public String getCoverUrl(){
		
		return coverUrl;
		
	}
	
	public Long getId(){
		return id;
	}
	
	public Long getApartmentId(){
		return apartmentId;
	}
	
	public Long getInitiatorId(){
		return initiatorId;
	}
	
	public String getActivity(){
		
		return activity;
	}
	
	public String getLocation(){
		
		return location;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getMessage(){
		return message;
	}
	
	public List<Long> getParticipants(){
		
		return participantId;
	}
	
	public String getInitiator(){
		
		return initiator;
	}

	@Override
	public int compareTo(Sports another) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
