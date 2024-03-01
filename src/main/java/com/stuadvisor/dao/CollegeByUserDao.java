package com.stuadvisor.dao;

import java.util.List;

import com.stuadvisor.model.CollegeByUserData;

public interface CollegeByUserDao {
	public int insertCollegeByUser(CollegeByUserData collegeByUserData);
	public int insertCollegeByUserList(List<CollegeByUserData> collegeByUserDataList);
	public boolean updateCollegeByUser(CollegeByUserData collegeByUserData);
	public boolean deleteCollegeByUser(CollegeByUserData collegeByUserData);
	public CollegeByUserData getSingleCollege(int collegeByUserDataId);
}
