package com.yun.homeplusplus;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Party implements Comparable<Party> {

	@Id
	private Long id;
	private Long apartmentId;
	private Long userId;
	
	private String userName;
	private String location;
	private String title;
	private String message;
	private String coverUrl;
	private Date date;
	
	private String dateString;
	private String timeString;
	
	private List<Long> participantsId;
	
	public Party(Long apartmentId, Long userId, String userName,String coverUrl, String location,
				String title, String message, String dataString, String timeString
				){
		
	}
	
	private Party(){
		
	}
	
	public void signUp(Long userId){
		
		participantsId.add(userId);
		
	}
	
	public void cancelSignUp(Long userId){
		
		participantsId.remove(userId);
		
	}
	
	
	public Long getUserId(){
		return userId;
	}
	
	public Long getApartmentId(){
		return apartmentId;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getLocation(){
		return location;
	}
	
	public Date  getDate(){
		return date;
	}
	
	public String getDateString(){
		return dateString;
	}
	
	public String getTimeString(){
		return timeString;
	}
	
	public String getCoverUrl(){
		return coverUrl;
	}
	
	
	@Override
	public int compareTo(Party another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
