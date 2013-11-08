package com.yun.homeplusplus;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


/**
 * 
 * @author Yun
 * 
 * Manager Class is the person who manage a apartment
 */

@Entity
public class Manager {
	
	@Id
	private Long id;
	private String aptName;
	private String state;
	private String city;
	private String email;      // email is used for login identify
	private String password;   // must have password to login
	
	public Manager(String email, String password, String state, String city, String aptName){
		
		this.email = email;
		this.password  = password;
		this.state =state;
		this.city = city;
		this.aptName = aptName;
		
	}
	
	
	public String getAptName(){
		
		return aptName;
	}
	
	
	

}
