package com.yun.homeplusplus;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

//administrator to clients
@Entity
public class Message implements Comparable<Message>  {

	@Id
	private Long id;
	private String receiver;
	private String sender;
	
	private String title;
	private String content;
	private Date createDate;
	
	private boolean isRead;
	
	public Message(String sender, String receiver, String title, String content){
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.content = content;
		this.createDate = new Date();
		this.isRead = false;
	}
	
	private Message(){
		
	}
	public String getSender(){
		return sender;
	}
	public String getReceiver(){
		return receiver;
	}
	public String getTitle(){
		return title;
	}
	public String getContent(){
		return content;
	}
	public void setRead(boolean flag){
		this.isRead = flag;
	}
	
	@Override
	public int compareTo(Message other) {
		if (other.createDate.after(createDate)) {
			return 1;
		} else if (other.createDate.before(createDate)) {
			return -1;
		}
		return 0;
	}
}
