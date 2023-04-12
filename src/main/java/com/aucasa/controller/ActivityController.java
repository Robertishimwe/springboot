package com.aucasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aucasa.model.Activity;
import com.aucasa.repository.ActivityRepository;
import com.aucasa.service.ActivityService;

@RestController
@RequestMapping("/aucasa/activities")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/new")
	public String createActivity(@RequestBody Activity activity) {
		
		return activityService.createActivity(activity);
	}
	@PostMapping("/update")
   public String updateActivity(@RequestBody Activity activity) {
		Activity act =activityService.findActivityById(activity.getActivityNumber());
		act.setDescription(activity.getDescription());
		act.setEndDate(activity.getEndDate());
		act.setStartingDate(activity.getStartingDate());
		act.setTitle(activity.getTitle());
		return activityService.createActivity(activity);
	}

    @GetMapping("/delete/{id}")
   public String deleteActivity(@PathVariable(value = "id") long id) {
	   return activityService.deleteActivity(id);
   }
    
    @GetMapping("/all")
    public List<Activity> findAllActivity(){
    	return activityService.allActivity();
    }
	
}
