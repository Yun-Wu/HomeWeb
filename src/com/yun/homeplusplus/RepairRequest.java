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
	
	private boolean isRead;
	
	
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
		this.isRead = false;
		
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
	
	public boolean isRead(){
		return isRead;
	}
	
	public void setRead(boolean flag){
		isRead = flag;
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

