package com.stuadvisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stuadvisor.model.RequestBlogData;
import com.stuadvisor.services.RequestBlogService;

@Controller
public class RequestBlogController {
	@Autowired
	private RequestBlogService requestBlogService;
	
	public RequestBlogService getRequestBlogService() {
		return requestBlogService;
	}

	public void setRequestBlogService(RequestBlogService requestBlogService) {
		this.requestBlogService = requestBlogService;
	}

	@PostMapping(path ="/sent-request-for-blog")
	public ResponseEntity<String> insertRequestBlog(@ModelAttribute RequestBlogData requestBlogData){
		String insertRequestBlog = this.requestBlogService.insertRequestBlog(requestBlogData);
		return ResponseEntity.ok(insertRequestBlog);
	}
}
