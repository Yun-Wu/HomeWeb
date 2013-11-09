package com.yun.homeplusplus;



import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class RepairRequest {
	
	@Id
	private Long id;
	private Long userId;
	private Integer roomNumber;
	
	private String userName;
	private Date createDate;
	private String title;
	private String content;
	private Integer priority;
	private List<String> pictureUrlList;
	
	
	public RepairRequest(Long userId, String userName, String title, String content, Integer priority,
							List<String> pictureUrlList, Integer roomNumber )
	{
		
		this.userId = userId;
		this.roomNumber = roomNumber;
		this.userName=userName;
		this.title = title;
		this.content = content;
		this.priority = priority;
		this.pictureUrlList = pictureUrlList;
		createDate = new Date();
		
	}
	
	private RepairRequest(){
		
	}


	
	public String getUserName() {
		return userName;
	}
	
	public Long getUserId(){
		return userId;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getContent(){
		return content;
	}
	
	
	public Integer getRoomNumber(){
		return roomNumber;
	}
	
	public Date getDate(){
		return createDate;
	}
	
	public Integer getPriority(){
		return priority;
	}
	
	

}

