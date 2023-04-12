package com.aucasa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aucasa.model.Activity;
import com.aucasa.model.Enquiry;
import com.aucasa.repository.ActivityRepository;
import com.aucasa.repository.EnquiryRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;
	
	
	public String createActivity(Activity activity) {
		
		repository.save(activity);
		return "Activity added successfully";
	}
	public String deleteActivity(long  enquiryId) {
		
		repository.deleteById(enquiryId);
		return "Activity deleted successfully";
		
	}
	
	public String updateActivity(Activity activity) {
		
		Activity currentActivity = repository.findById(activity.getActivityNumber()).get();
		currentActivity.setDescription(activity.getDescription());
		currentActivity.setEndDate(activity.getEndDate());
		currentActivity.setTitle(activity.getTitle());
		repository.save(currentActivity);
		return "Activity updated";
		
	}
	
	public List<Activity> allActivity(){
		
		return repository.findAll();
	}
	
	public Activity findActivityById(long id) {
		return repository.findById(id).get();
	}
}
