package com.stuadvisor.dao;

import java.util.List;
import java.util.Set;

import com.stuadvisor.model.CollegesData;

public interface CollegesDataDao {
	public int insertCollege(CollegesData collegesData);
	public int insertCollegeList(List<CollegesData> collegesDataList);
	public boolean updateCollege(CollegesData collegesData);
	public boolean deleteCollege(CollegesData collegesData);
	public CollegesData getSingleCollege(int collegesDataId);
	public List<CollegesData> searchByCity(String city);
	public List<CollegesData> searchByState(String state);
	public List<CollegesData> searchByCourse(String course);
	public List<CollegesData> searchAllTypeCollege(String city,String state,String course);
	public List<CollegesData> getAllCollege();
	public Set<String> getCourseName();
}	
