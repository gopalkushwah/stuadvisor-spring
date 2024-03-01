package com.stuadvisor.dao;

import java.util.List;

import com.stuadvisor.model.UserData;

public interface UserDataDao {
	public int insertUser(UserData userData);
	public int insertUserList(List<UserData> userDatas);
	public boolean updateUser(UserData userData);
	public boolean deleteUser(UserData userData);
	public UserData getSingleUser(int userId);
	public List<UserData>  getSingleUserByMobile(String mobile);
	public List<UserData>  getSingleUserWhereMobileIsNot(String msId,String mobile);
	public List<UserData>  getSingleUserWhereEmailIsNot(String msId,String email);
	public List<UserData>  getSingleUserByEmail(String email);
	public List<UserData>  getSingleUserByEmailAndMobile(String email,String mobile);
	public UserData getSingleUserByMsId(String msId);
	public List<UserData> getAllUser();
	
}
