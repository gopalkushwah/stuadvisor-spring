package com.stuadvisor.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stuadvisor.dao.CollegeByUserDao;
import com.stuadvisor.model.CollegeByUserData;

@Service
public class CollegeByUserService {

	@Autowired
	private CollegeByUserDao collegeByUserDaoImpl;

	public CollegeByUserDao getCollegeByUserDaoImpl() {
		return collegeByUserDaoImpl;
	}

	public void setCollegeByUserDaoImpl(CollegeByUserDao collegeByUserDaoImpl) {
		this.collegeByUserDaoImpl = collegeByUserDaoImpl;
	}
	
	

	public int insertCollegeByUser(CollegeByUserData collegeByUserData) {
		return (Integer) this.collegeByUserDaoImpl.insertCollegeByUser(collegeByUserData);
	}

	public int insertCollegeByUserList(List<CollegeByUserData> collegeByUserDataList) {
		return this.collegeByUserDaoImpl.insertCollegeByUserList(collegeByUserDataList);
	}

	public boolean updateCollegeByUser(CollegeByUserData collegeByUserData) {
		return this.collegeByUserDaoImpl.updateCollegeByUser(collegeByUserData);
	}

	public boolean deleteCollegeByUser(CollegeByUserData collegeByUserData) {
		return this.collegeByUserDaoImpl.deleteCollegeByUser(collegeByUserData);
	}

	public CollegeByUserData getSingleCollege(int collegeByUserDataId) {
		return this.collegeByUserDaoImpl.getSingleCollege(collegeByUserDataId);
	}

}
