package com.stuadvisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stuadvisor.model.ContactUsData;
import com.stuadvisor.services.ContactUsService;

@Controller
public class ContactUsController {

	@Autowired
	private ContactUsService contactUsService;
	
	@PostMapping("/contact-us-message")
	public ResponseEntity<String> sendMessage(@ModelAttribute ContactUsData contactUsData){
		int insertMessage = this.contactUsService.insertMessage(contactUsData);
		if (insertMessage>0) {
			return ResponseEntity.ok("Message Sent Successfull, We will figure it out , Thank You for this response 🙏");
		}
		return ResponseEntity.badRequest().body("Something Went Wrong , Please Try Again!");
		
	}
}
