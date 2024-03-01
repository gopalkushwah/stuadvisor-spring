package com.stuadvisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuadvisor.model.ReviewsData;
import com.stuadvisor.services.ReviewsDataService;

@Controller
public class ReviewsController {

	@Autowired
	private ReviewsData reviewsData;
	
	@Autowired
	private ReviewsDataService dataService;
	
	@PostMapping("/post-review-data")
	public ResponseEntity<String> postReviews(
			@RequestParam("name") String name,
			@RequestParam("userid") String userid,
			@RequestParam("userimg") String userimg,
			@RequestParam("stars") String stars,
			@RequestParam("reviewsdata") String reviewsdesc
			){
		this.reviewsData.setPostBy(name);
		this.reviewsData.setReview(reviewsdesc);
		this.reviewsData.setStars(stars);
		this.reviewsData.setUserId(userid);
		this.reviewsData.setUserProfileImage(userimg);
		
		int insertReviews = this.dataService.insertReviews(reviewsData);
		if(insertReviews>0) {
			return ResponseEntity.ok("Review Sent Successfuly");	
		}else {
			return ResponseEntity.ok("Something Went Wrong!");	
		}
	}
}
