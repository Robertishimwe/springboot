package com.aucasa.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private Date startingDate;
    private Date endDate;
    private String title;
    private String description;
    
    
    
    
	public long getActivityNumber() {
		return id;
	}
	public void setActivityNumber(long activityNumber) {
		this.id = activityNumber;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
