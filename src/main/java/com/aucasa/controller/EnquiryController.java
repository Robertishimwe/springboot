package com.aucasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aucasa.model.Enquiry;
import com.aucasa.model.Post;
import com.aucasa.service.EnquiryService;
import com.aucasa.service.PostService;

@RestController
@RequestMapping("/aucasa/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	
	@PostMapping("/new")
	public String createEnquiry(@RequestBody Enquiry enquiry) {
		
		return enquiryService.createEnquiry(enquiry);
	}
	@PostMapping("/update")
   public String updateEnquiry(@RequestBody Enquiry enquiry) {
		Enquiry enq =enquiryService.findEnquiryById(enquiry.getEnquiryNumber());
		enq.setDescription(enquiry.getDescription());
		
		enq.setSubmissionDate(enquiry.getSubmissionDate());
		
		return enquiryService.updateEnquiry(enquiry);
	}

    @GetMapping("/delete/{id}")
   public String deleteEnquiry(@PathVariable(value = "id") long id) {
	   return enquiryService.deleteEnquiry(id);
   }
    
    @GetMapping("/all")
    public List<Enquiry> findAllEnquiry(){
    	return enquiryService.allEnquiry();
    }
}
