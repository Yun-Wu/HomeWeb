package com.yun.homeplusplus;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * 
 * @author Xianlei
 * 
 * This object must be created by manger, with the purpose to protect privacy of residents.
 * 
 */


@Entity
public class Resident {
	
	@Id
	private Long id;
	private Long apartmentId;  // convenient for get user in same apartment
	
	private String state;
	private String city;
	private String aptName;  // apartment name
	private Integer roomNumber;  

	
	private String name;    
	private String email;    // used for login in
							 // must get authority from manger.
							 // After getting authority from manger, residents could login in android 
	
	private String gender;   // male or female
	
	public String photoUrl; // photo for residents
	public String status;   // used for social;
	private Integer age;
	
	
	// constructor of Residents
	private Resident(){
	}
	
	public Resident(Integer roomNumber, String email, String name, String state, String city, String aptName, 
							String gender, Integer age, Long apartmentId)
	{
		
		this.roomNumber = roomNumber;
		this.email =  email;
		this.name  =  name;
		this.state = state;
		this.city  = city;
		this.aptName= aptName;
		this.gender = gender;
		this.age = age;
		this.apartmentId = apartmentId;
		
	}
	
	public String getState(){
		return state;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getAptName(){
		return aptName;
	}
	
	public String getName(){
		return name;
	}
	
	public void removeFromApt(){
		
		apartmentId =null;
		
	}
	
	
	
	
	
	

}
