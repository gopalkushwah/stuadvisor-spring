package com.stuadvisor.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.stuadvisor.model.*;
import com.stuadvisor.services.*;

@Controller
public class SearchCollegeController {
	
	@Autowired
	private SearchCollegeDataService searchCollegeDataService;
	
	@Autowired
	private TopCollegesDataService topCollegesDataService;
	
	
	@RequestMapping("/search-colleges")
	public String searchColleges(Model model) {
		model.addAttribute("title","Search Colleges");
		return "search-colleges";
	}
	
	@RequestMapping("/top-colleges")
	public String topColleges(Model model) {
		model.addAttribute("title","Top Colleges");
		return "top-colleges";
	}
	@RequestMapping("/course-wise-colleges")
	public String courseWiseColleges(Model model) {
		model.addAttribute("title","Course Wise Colleges");
		Set<String> courseName = this.searchCollegeDataService.getCourseName();
		System.out.println(courseName);
		model.addAttribute("courseName", courseName);
		return "course-wise-colleges";
	}
	@RequestMapping("/city-wise-colleges")
	public String cityWiseColleges(Model model) {
		model.addAttribute("title","City Wise Colleges");
		return "city-wise-colleges";
	}
	
	@RequestMapping("/state-wise-colleges")
	public String stateWiseColleges(Model model) {
		model.addAttribute("title","State Wise Colleges");
		return "state-wise-colleges";
	}
	
	@RequestMapping(path = "/getTopCollege",method = RequestMethod.POST)
	public ResponseEntity<String> getTopColleges(@RequestParam("page") int page,@RequestParam("pageSize") int size){
		try {
			List<TopCollegesData> topCollege = this.topCollegesDataService.getTopCollege(page, size);
			System.out.println(topCollege);
			Gson gson = new Gson();
			String json = gson.toJson(topCollege);
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			return ResponseEntity.ok("Something went wrong!");
		}
	}
	
	@RequestMapping(path="/search-city-clg",method = RequestMethod.POST)
	public ResponseEntity<String> searchByCityName(@RequestParam("cityWise") String city) {
		try {
			List<CollegesData> searchByCityNameClg = this.searchCollegeDataService.searchByCityName(city);
			Gson gson = new Gson();
			String json = gson.toJson(searchByCityNameClg);
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			return ResponseEntity.ok("Something went wrong!");
		}
	}
	
	@RequestMapping(path="/search-course-clg",method = RequestMethod.POST)
	public ResponseEntity<String> searchByCourseName(@RequestParam("course") String course) {
		try {
			List<CollegesData> searchByCourseNameClg= this.searchCollegeDataService.searchByCourseName(course);
			Gson gson = new Gson();
			String json = gson.toJson(searchByCourseNameClg);
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			return ResponseEntity.ok("Something went wrong!");
		}
	}
	
	@RequestMapping(path="/search-state-clg",method = RequestMethod.POST)
	public ResponseEntity<String> searchByStateName(@RequestParam("state") String state) {
		try {
			List<CollegesData> searchByStateNameClg= this.searchCollegeDataService.searchByStateName(state);
			Gson gson = new Gson();
			String json = gson.toJson(searchByStateNameClg);
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something went Wrong!");
		}
	}
	
	@RequestMapping(path="/search",method = RequestMethod.POST)
	public ResponseEntity<String> searchAllType(@RequestParam("course") String course) {
		String state = course;
		String city = course;
		try {
			List<CollegesData> searchAllTypeClg= this.searchCollegeDataService.getAllType(city, state, course);
			Gson gson = new Gson();
			String json = gson.toJson(searchAllTypeClg);
			return ResponseEntity.ok(json);
		} catch (Exception e) {
			return ResponseEntity.ok("Something went wrong!");
		}
	}
	
//	@RequestMapping(path="insertAll")
//	public String saveAll() {
//		try {
//			List<CollegesData> topCollegesDatas = jsonFileReaderService.readJsonFile("colleges.json");
//			int createCollegesData = searchCollegeDataService.createCollegesDataList(topCollegesDatas);
//			System.out.println(createCollegesData);
//			return "insertedDone";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "errors/error-404";
//		}
//	}
}
