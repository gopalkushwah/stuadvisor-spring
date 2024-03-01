package com.stuadvisor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuadvisor.dao.TopCollegesDao;
import com.stuadvisor.model.TopCollegesData;

@Service
public class TopCollegesDataService {
	
	@Autowired
	private TopCollegesDao collegesDaoImpl;
	
	public TopCollegesDao getCollegesDaoImpl() {
		return collegesDaoImpl;
	}

	public void setCollegesDaoImpl(TopCollegesDao collegesDaoImpl) {
		this.collegesDaoImpl = collegesDaoImpl;
	}

	public int insertTopCollege(TopCollegesData topCollegesData) {
		return (Integer)this.collegesDaoImpl.insertTopCollege(topCollegesData);
	}

	public int insertTopCollegeList(List<TopCollegesData> topCollegesDatas) {
		try {
			return this.collegesDaoImpl.insertTopCollegeList(topCollegesDatas);
		} catch (Exception e) {
			return 0;
		}
	}

	public boolean updateTopCollege(TopCollegesData topCollegesData) {
		try {
			this.collegesDaoImpl.updateTopCollege(topCollegesData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteTopCollege(TopCollegesData topCollegesData) {
		try {
			this.collegesDaoImpl.deleteTopCollege(topCollegesData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TopCollegesData getSingleTopCollege(int topCollegeId) {
		try {
			return this.collegesDaoImpl.getSingleTopCollege(topCollegeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<TopCollegesData> getAllTopCollege() {
		try {
			return this.collegesDaoImpl.getAllTopCollege();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<TopCollegesData> getTopCollege(int page, int size) {
		return this.collegesDaoImpl.getTopCollege(page, size);
	}
	
}
