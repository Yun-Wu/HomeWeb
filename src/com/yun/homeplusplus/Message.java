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
	private Long receiverId;
	private String sender;
	private Long senderId;
	
	private String title;
	private String content;
	private Date createDate;
	
	private String coverUrl;
	
	private boolean isRead;
	
	public Message(String sender, Long senderId, String receiver, Long receiverId, String title, String content){
		this.sender = sender;
		this.receiver = receiver;
		this.receiverId = receiverId;
		this.title = title;
		this.content = content;
		this.createDate = new Date();
		this.isRead = false;
		this.senderId = senderId;
	}
	
	private Message(){
		
	}
	public Long getId(){
		return id;
	}
	public String getSender(){
		return sender;
	}
	public String getReceiver(){
		return receiver;
	}
	public Long getReceiverId(){
		return receiverId;
	}
	public Long getSenderId(){
		return senderId;
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
	public void setUrl(String url){
		this.coverUrl = url;
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
