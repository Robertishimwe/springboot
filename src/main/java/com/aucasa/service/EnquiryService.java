package com.aucasa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aucasa.model.Enquiry;
import com.aucasa.model.Post;
import com.aucasa.repository.EnquiryRepository;
import com.aucasa.repository.PostRepository;

@Service
public class EnquiryService {

	@Autowired
	private EnquiryRepository repository;
	
	
	public String createEnquiry(Enquiry enquiry) {
		
		repository.save(enquiry);
		return "Enquiry added successfully";
	}
	public String deleteEnquiry(long  enquiryId) {
		
		repository.deleteById(enquiryId);
		return "Enquiry deleted successfully";
		
	}
	
	public String updateEnquiry(Enquiry enquiry) {
		
		Enquiry currentEnquiry = repository.findById(enquiry.getEnquiryNumber()).get();
		currentEnquiry.setDescription(enquiry.getDescription());
		currentEnquiry.setSubmissionDate(enquiry.getSubmissionDate());
		repository.save(currentEnquiry);
		return "Enquiry updated";
		
	}
	
	public List<Enquiry> allEnquiry(){
		
		return repository.findAll();
	}
	
	public Enquiry findEnquiryById(long id) {
		return repository.findById(id).get();
	}
}
