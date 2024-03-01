package com.stuadvisor.dao;

import java.util.List;
import com.stuadvisor.model.TopCollegesData;

public interface TopCollegesDao {
	public int insertTopCollege(TopCollegesData topCollegesData);
	public int insertTopCollegeList(List<TopCollegesData> topCollegesDatas);
	public boolean updateTopCollege(TopCollegesData topCollegesData);
	public boolean deleteTopCollege(TopCollegesData topCollegesData);
	public TopCollegesData getSingleTopCollege(int topCollegeId);
	public List<TopCollegesData> getAllTopCollege();
	public List<TopCollegesData> getTopCollege(int page,int size);
}
