package com.stuadvisor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuadvisor.model.BlogsData;
import com.stuadvisor.model.RequestBlogData;
import com.stuadvisor.services.BlogsDataService;
import com.stuadvisor.services.RequestBlogService;

@Controller
public class BlogsController {

//	@Autowired
//	private JsonFileReaderService fileReaderService;;

	@Autowired
	private BlogsData blogsData;

	@Autowired
	private BlogsDataService blogsDataService;

	@Autowired
	private RequestBlogService requestBlogService;

	@RequestMapping(path = "/blogs")
	public String blogs(Model model) {
		model.addAttribute("title", "Search Blogs");

		return "Blogs";
	}

	@RequestMapping(path = "/trending-blogs")
	public String trendingBlogs(Model model) {
		List<BlogsData> allBlog = this.blogsDataService.getAllBlog();
		model.addAttribute("allBlog", allBlog);
		model.addAttribute("title", "Trending Blogs");

		return "trending-blogs";
	}

	@RequestMapping(path = "/education-blogs")
	public String educationBlog(Model model) {
		model.addAttribute("title", "Educational Blogs");

		return "education-blogs";
	}

	@RequestMapping(path = "/other-blogs")
	public String otherBlogs(Model model) {
		model.addAttribute("title", "Other Blogs");

		return "other-blogs";
	}

	@RequestMapping(path = "/request-blog")
	public String requestBlog(Model model) {
		model.addAttribute("title", "Request Blogs");
		List<RequestBlogData> requestBlogDataList = this.requestBlogService.getRequestBlogDataList();
		model.addAttribute("requestBlogDataList",requestBlogDataList);
		
		return "request-blogs";
	}

//	******** TO GET EDUCATIONAL BLOGS BY TITLE *****************************
	@PostMapping(path = "/get-educational-blogs")
	public ResponseEntity<String> getEducationalBlogs(@RequestParam("search") String title) {
		String educationalBlog = this.blogsDataService.getEducationalBlog(title);
		return ResponseEntity.ok(educationalBlog);
	}

//	******** TO GET ANY EDUCATIONAL BLOGS BY TITLE *****************************
	@PostMapping(path = "/get-any-educational-blogs")
	public ResponseEntity<String> getAnyEducationalBlogs(@RequestParam("search") String title) {
		String allBlog = this.blogsDataService.getAnyEducationalBlog(title);
		return ResponseEntity.ok(allBlog);
	}

//	******** TO GET All OTHER BLOGS BY TITLE *****************************
	@PostMapping(path = "/get-other-blogs")
	public ResponseEntity<String> getOtherBlogs(@RequestParam("search") String title) {
		String allBlog = this.blogsDataService.getOtherBlog(title);
		return ResponseEntity.ok(allBlog);
	}

	@PostMapping(path = "/post-blogs-data")
	public ResponseEntity<String> postBlogsData(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("category") String category,
			@RequestParam("postBy") String postBy, @RequestParam("userId") String userId,
			@RequestParam("userProfileImage") String userProfileImage) {
		BlogsData lastRow = this.blogsDataService.getLastRow();
		blogsData.setCategory(category);
		blogsData.setDescription(description);
		blogsData.setHtmlId("studentadvisor" + (lastRow.getId() + 1));
		blogsData.setPostBy(postBy);
		blogsData.setTitle(title);
		blogsData.setUserId(userId);
		blogsData.setUserProfileImage(userProfileImage);
		int insertBlogs = this.blogsDataService.insertBlogs(blogsData);
		if (insertBlogs > 0) {
			return ResponseEntity.ok("Blog Posted Successful");
		} else {
			return ResponseEntity.ok("Something went Wrong!");
		}

	}
}
