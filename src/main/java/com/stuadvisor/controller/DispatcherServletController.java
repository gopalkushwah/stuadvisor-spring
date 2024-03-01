package com.stuadvisor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stuadvisor.model.ReviewsData;
import com.stuadvisor.model.UserData;
import com.stuadvisor.services.ReviewsDataService;
import com.stuadvisor.services.SetCookies;

@Controller
public class DispatcherServletController {
	
	@Autowired
	private ReviewsDataService reviewsDataService;
	
	@RequestMapping(path="/")
	public String home(Model model) {
		model.addAttribute("title","Home");
		
		return "index";
	}
	@RequestMapping(path="/reviews")
	public String reviews(Model model) {
		model.addAttribute("title","Reviews");
		List<ReviewsData> topReviews = this.reviewsDataService.getTopReviews();
		List<ReviewsData> allReviews = this.reviewsDataService.getAllReviews();
		model.addAttribute("topReviews",topReviews);
		model.addAttribute("allReviews",allReviews);
		return "reviews";
	}
	@RequestMapping(path="/about")
	public String about(Model model) {
		model.addAttribute("title","About Us");
		
		return "aboutus";
	}
	@RequestMapping(path="/contact")
	public String contact(Model model,HttpServletRequest httpServletRequest) {
		model.addAttribute("title","Contact Us");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", httpServletRequest);
		if(userCookie!=null)
			model.addAttribute("userCookie",userCookie);
		return "contactus";
	}
	@RequestMapping(path="/news")
	public String  news(Model model) {
		model.addAttribute("title","News");
		
		return "news";
	}
}
