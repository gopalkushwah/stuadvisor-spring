package com.stuadvisor.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stuadvisor.model.StudyMaterialData;
import com.stuadvisor.services.CourseDataService;
import com.stuadvisor.services.StudyMaterialServices;

@Controller
public class AcademicsController {
	
	@Autowired
	private CourseDataService courseDataService;
	
	@Autowired
	private StudyMaterialServices studyMaterialServices;
	
	public CourseDataService getCourseDataService() {
		return courseDataService;
	}

	public void setCourseDataService(CourseDataService courseDataService) {
		this.courseDataService = courseDataService;
	}

	public StudyMaterialServices getStudyMaterialServices() {
		return studyMaterialServices;
	}

	public void setStudyMaterialServices(StudyMaterialServices studyMaterialServices) {
		this.studyMaterialServices = studyMaterialServices;
	}
	

	@RequestMapping("/academics")
	public String academics(Model model, HttpServletResponse response, HttpServletRequest request) {
		model.addAttribute("title","Academics");
		
		Cookie[] cookies = request.getCookies();
		Set<String> courseName = new HashSet<>();
		boolean isCourseName = false;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("courseName")) {
					isCourseName = true;
				};
			}
		}
		if (!isCourseName) {
			courseName = this.courseDataService.getCourseName();
			model.addAttribute("courseName", courseName);
			String delimitedString = String.join(",", courseName);
			Cookie cookie = new Cookie("courseName", delimitedString);
			cookie.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(cookie);
		}
		return "academics";
	}

	@RequestMapping("/imp-que")
	public String impQue(Model model) {
		Set<String> courseName = this.courseDataService.getCourseName();
		model.addAttribute("courseName", courseName);
		model.addAttribute("title","Important Questions");
		return "imp-que";
	}

	@RequestMapping("/sample-paper")
	public String samplePaper(Model model) {
		model.addAttribute("title","Sample Paper");
		return "sample-paper";
	}

	@RequestMapping("/previous-paper")
	public String previousPaper(Model model) {
		model.addAttribute("title","Previous Year Paper");
		return "previous-paper";
	}

	@RequestMapping("/study-material")
	public String studyMaterial(Model model) {
		model.addAttribute("title","Study Material");
		List<StudyMaterialData> studyMaterialDatas = this.studyMaterialServices.getStudyMaterialDatas();
		Collections.shuffle(studyMaterialDatas);
		model.addAttribute("studyMaterialDatas",studyMaterialDatas);
		return "study-material";
	}
	
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@RequestMapping("/**")
//	public String handleException() {
//		return "errors/error-404";
//	}
}
