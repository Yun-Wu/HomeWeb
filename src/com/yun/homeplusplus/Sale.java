package com.yun.homeplusplus;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



@Entity
public class Sale {
	
	@Id
	private Long id;
	private Long userId;
	private Long apartmentId;
	
	private String title;
	private String description;
	private Integer price;
	private List<String> pictureUrlList;
	
	
	public Sale(Long userId, Long apartmentId, String title, String description, Integer price, List<String> pictureUrlList){
		
		this.userId = userId;
		this.apartmentId = apartmentId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pictureUrlList = pictureUrlList;
		
	}
	
	private Sale(){
		
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Integer getPrice(){
		return price;
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
	

}