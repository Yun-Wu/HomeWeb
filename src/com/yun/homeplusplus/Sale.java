package com.yun.homeplusplus;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



@Entity
public class Sale implements Comparable<Sale> {
	
	@Id
	private Long id;
	private Long userId;
	private String userName;
	private Long apartmentId;
	
	private String title;
	private String description;
	private Integer price;
	private String coverUrl;
	private String pictureUrl;
	
	
	public Sale(Long userId, String userName, Long apartmentId, String title, String description, Integer price, 
			String pictureUrl, String coverUrl){
		
		this.userId = userId;
		this.userName = userName;
		this.apartmentId = apartmentId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pictureUrl = pictureUrl;
		this.coverUrl = coverUrl;
		
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
	
	public String getCoverUrl(){
		
		return coverUrl;
		
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPictureUrl(){
		return pictureUrl;
	}

	@Override
	public int compareTo(Sale another) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
