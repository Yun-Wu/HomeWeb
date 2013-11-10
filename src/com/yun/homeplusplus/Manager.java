package com.yun.homeplusplus;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


/**
 * 
 * @author Xianlei
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
	
	private Manager(){
	}
	
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
	
	public Long getAptId(){
		return id;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getState(){
		return state;
	}
	
	public String getCity(){
		return city;
	}

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Manager))
            return false;

        Manager rhs = (Manager) obj;
        return rhs.getEmail().equals(this.email);
    }
}
