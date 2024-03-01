package com.stuadvisor.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuadvisor.dao.CourseDataDao;
import com.stuadvisor.model.CourseData;

@Service
public class CourseDataService {

	@Autowired
	public CourseDataDao courseDataDaoImpl;
	
// ************************ SETTERS AND GETTERS FOR courseDataDaoImpl
	public CourseDataDao getCourseDataDaoImpl() {
		return courseDataDaoImpl;
	}

	public void setCourseDataDaoImpl(CourseDataDao courseDataDaoImpl) {
		this.courseDataDaoImpl = courseDataDaoImpl;
	}

	
//	.********************* SERVICE METHODS **************************
	
	public int createCoursesDataList(List<CourseData> courseDatas) {
		return this.courseDataDaoImpl.insertCourseList(courseDatas);
	}
	
	public Set<String> getCourseName(){
		return this.courseDataDaoImpl.getCourseName();
	}
	public Set<String> getBranchesNameService(String course){
		return this.courseDataDaoImpl.getBranchesName(course);
	}
	public List<CourseData> getAllCourses(String course){
		return this.courseDataDaoImpl.getAllCourses(course);
	}
	public Set<String> getSem(String course,String branch){
		return this.courseDataDaoImpl.getSemName(course, branch);
	}
	public List<CourseData> getSub(String course,String branch,String sem){
		return this.courseDataDaoImpl.getSubName(course, branch,sem);
	}
	public List<CourseData> getImp(String course,String branch,String sem){
		return this.courseDataDaoImpl.getImpName(course, branch,sem);
	}
	public List<CourseData> getPaper(String course,String branch,String sem){
		return this.courseDataDaoImpl.getPaperName(course, branch,sem);
	}
	public List<CourseData> getSample(String course,String branch,String sem){
		return this.courseDataDaoImpl.getSampleName(course, branch,sem);
	}
}
