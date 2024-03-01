package com.stuadvisor.dao;

import java.util.List;
import java.util.Set;

import com.stuadvisor.model.CourseData;

public interface CourseDataDao {
	public int insertCourse(CourseData courseData);
	public int insertCourseList(List<CourseData> courseDatas);
	public boolean updateCourse(CourseData courseData);
	public boolean deleteCourse(CourseData courseData);
	public CourseData getSingleCourse(int courseId);
	public List<CourseData> getAllCourse();
	public List<CourseData> getAllCourses(String course);
	public Set<String> getCourseName();
	public Set<String> getBranchesName(String course);
	public Set<String> getSemName(String course,String branch);
	public List<CourseData> getSubName(String course,String branch,String sem);
	public List<CourseData> getImpName(String course,String branch,String impque);
	public List<CourseData> getPaperName(String course,String branch,String impque);
	public List<CourseData> getSampleName(String course,String branch,String impque);
}
