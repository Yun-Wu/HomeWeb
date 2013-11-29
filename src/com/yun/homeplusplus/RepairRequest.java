package com.yun.homeplusplus;



import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class RepairRequest implements Comparable<RepairRequest> {
	
	@Id
	private Long id;
	private Long userId;
	private Long aptId;
	private Integer roomNumber;
	
	private String userName;
	private Date createDate;
	private String title;
	private String content;
	private Integer priority;
	private List<String> pictureUrlList;
	
	private String scheduledDate;  // format  DD/MM/YY		   ex.   27/11/2013
	private String scheduledTime;  // format  Hour in 24:min   ex.   17:05
	
	private Integer responded;	   // 1: responded by management office
								   // 0; unresponded
	
	
	public RepairRequest(Long userId, Long aptId, String userName, String title, String content, Integer priority,
							List<String> pictureUrlList, Integer roomNumber )
	{
		
		this.userId = userId;
		this.aptId = aptId;
		this.roomNumber = roomNumber;
		this.userName=userName;
		this.title = title;
		this.content = content;
		this.priority = priority;
		this.pictureUrlList = pictureUrlList;
		createDate = new Date();
		
		scheduledTime = "N/A";  // initialize this value
		scheduledDate = "N/A";
		responded = 0;
		
	}
	
	private RepairRequest(){
		
	}

	public Long getRequestId(){
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public Long getUserId(){
		return userId;
	}
	
	public Long getAptId(){
		return aptId;
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
	
	public List<String> getImageList(){
		return pictureUrlList;
	}
	
public String getScheduledDate(){
		
		return scheduledDate;
	}
	
	public String getScheduledTime(){
		return scheduledTime;
	}
	
	public Integer getResponded(){
		
		return responded;
		
	}
	public void setScheduledDate(String date){
		
		scheduledDate = date;
		
	}
	
	public void setScheduledTime(String time){
		
		scheduledTime = time;
	}
	
	public void setResponded(){
		responded = 1;
	}

	
	@Override
	public int compareTo(RepairRequest other) {
		if (other.createDate.after(createDate)) {
			return 1;
		} else if (other.createDate.before(createDate)) {
			return -1;
		}
		return 0;
	}

}

