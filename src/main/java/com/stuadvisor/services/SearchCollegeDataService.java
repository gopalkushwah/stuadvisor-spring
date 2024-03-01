package com.stuadvisor.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuadvisor.dao.CollegesDataDao;
import com.stuadvisor.model.CollegesData;

@Service
public class SearchCollegeDataService {
	@Autowired
	private CollegesDataDao collegesDaoImpl;

	public CollegesDataDao getCollegesDaoImpl() {
		return collegesDaoImpl;
	}

	public void setCollegesDaoImpl(CollegesDataDao collegesDaoImpl) {
		this.collegesDaoImpl = collegesDaoImpl;
	}

	public int createCollegesData(CollegesData collegesData) {
		return this.collegesDaoImpl.insertCollege(collegesData);
	}
	
	public int createCollegesDataList(List<CollegesData> collegesDataList) {
		return this.collegesDaoImpl.insertCollegeList(collegesDataList);
	}
	
	public boolean updateCollegeData(CollegesData collegesData) {
		return this.collegesDaoImpl.updateCollege(collegesData);
	}
	public boolean deleteCollegeData(CollegesData collegesData) {
		return this.collegesDaoImpl.deleteCollege(collegesData);
	}
	public CollegesData getSingleCollege(int collegeId) {
		return this.collegesDaoImpl.getSingleCollege(collegeId);
	}
	public List<CollegesData> getAllCollege() {
		return this.collegesDaoImpl.getAllCollege();
	}
	
	public List<CollegesData> searchByCityName(String city) {
		return this.collegesDaoImpl.searchByCity(city);
	}
	
	public List<CollegesData> searchByStateName(String state) {
		return this.collegesDaoImpl.searchByState(state);
	}
	
	public List<CollegesData> searchByCourseName(String course) {
		return this.collegesDaoImpl.searchByCourse(course);
	}
	public Set<String> getCourseName() {
		return this.collegesDaoImpl.getCourseName();
	}
	public List<CollegesData> getAllType(String city,String state,String course) {
		return this.collegesDaoImpl.searchAllTypeCollege(city,state,course);
	}
	
	
	
}
