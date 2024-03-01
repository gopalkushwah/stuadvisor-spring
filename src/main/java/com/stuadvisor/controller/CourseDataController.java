package com.stuadvisor.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.stuadvisor.model.CourseData;
import com.stuadvisor.services.CourseDataService;

@Controller
public class CourseDataController {
	
	@Autowired
	private CourseDataService courseDataService;
	
	@RequestMapping(path = "/get-branchs-name")
	public ResponseEntity<String> getBranchesName(@RequestParam("course") String course){
		Set<String> branchesName = this.courseDataService.getBranchesNameService(course);
		Gson gson = new Gson();
		String json = gson.toJson(branchesName);
		return ResponseEntity.ok(json);
	}
	@RequestMapping(path = "/get-course-name")
	public ResponseEntity<String> getCourseName(@RequestParam("course") String course){
		Set<String> branchesName = this.courseDataService.getCourseName();
		Gson gson = new Gson();
		String json = gson.toJson(branchesName);
		return ResponseEntity.ok(json);
	}
	
	@RequestMapping(path = "/get-all-courses",method = RequestMethod.POST)
	public ResponseEntity<String> getAllCourses(@RequestParam("course") String course){
		List<CourseData> courseDatas = this.courseDataService.getAllCourses(course);
		Gson gson = new Gson();
		String json = gson.toJson(courseDatas);
		return ResponseEntity.ok(json);
	}
	
	@RequestMapping(path = "/get-sem",method = RequestMethod.POST)
	public ResponseEntity<String> getSem(@RequestParam("branch") String branch,@RequestParam("course") String course){
		Set<String> semDatas = this.courseDataService.getSem(course, branch);
		Gson gson = new Gson();
		String json = gson.toJson(semDatas);
		return ResponseEntity.ok(json);
	}
	@RequestMapping(path = "/get-subject",method = RequestMethod.POST)
	public ResponseEntity<String> getSubject(@RequestParam("branch") String branch,@RequestParam("course") String course,@RequestParam("sem") String sem){
		List<CourseData> subDatas = this.courseDataService.getSub(course, branch, sem);
		Gson gson = new Gson();
		String json = gson.toJson(subDatas);
		return ResponseEntity.ok(json);
	}
	@RequestMapping(path = "/get-imp",method = RequestMethod.POST)
	public ResponseEntity<String> getImp(@RequestParam("branch") String branch,@RequestParam("course") String course,@RequestParam("sem") String sem){
		List<CourseData> impqueDatas = this.courseDataService.getImp(course, branch, sem);
		Gson gson = new Gson();
		String json = gson.toJson(impqueDatas);
		return ResponseEntity.ok(json);
	}
	@RequestMapping(path = "/get-paper",method = RequestMethod.POST)
	public ResponseEntity<String> getPaper(@RequestParam("branch") String branch,@RequestParam("course") String course,@RequestParam("sem") String sem){
		List<CourseData> paperDatas = this.courseDataService.getPaper(course, branch, sem);
		Gson gson = new Gson();
		String json = gson.toJson(paperDatas);
		return ResponseEntity.ok(json);
	}
	@RequestMapping(path = "/get-sample",method = RequestMethod.POST)
	public ResponseEntity<String> getSample(@RequestParam("branch") String branch,@RequestParam("course") String course,@RequestParam("sem") String sem){
		List<CourseData> paperDatas = this.courseDataService.getSample(course, branch, sem);
		Gson gson = new Gson();
		String json = gson.toJson(paperDatas);
		return ResponseEntity.ok(json);
	}

}
