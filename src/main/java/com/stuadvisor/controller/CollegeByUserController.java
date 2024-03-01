package com.stuadvisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stuadvisor.model.CollegeByUserData;
import com.stuadvisor.services.CollegeByUserService;

@Controller
public class CollegeByUserController {

	@Autowired
	private CollegeByUserService collegeByUserService;
	
	@PostMapping("/insert-college-by-user")
	public ResponseEntity<String> insertCollegeByUser(@ModelAttribute CollegeByUserData collegeByUserData){
		int insertCollegeByUser = this.collegeByUserService.insertCollegeByUser(collegeByUserData);
		if(insertCollegeByUser>0)
			return ResponseEntity.ok("College Has Been Saved");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}
	
}
