package com.stuadvisor.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuadvisor.dao.UserDataDao;
import com.stuadvisor.model.UserData;

@Service
public class UserDatasService {

	@Autowired
	private UserData userData;
	
	@Autowired
	private UserDataDao userDataDaoImpl;

	public UserDataDao getUserDataDaoImpl() {
		return userDataDaoImpl;
	}

	public void setUserDataDaoImpl(UserDataDao userDataDaoImpl) {
		this.userDataDaoImpl = userDataDaoImpl;
	}
	
	public String insertUser(UserData userData,String email,String password,String mobile) {

//		Checking if user email any mobile exist or not
		boolean singleUserByMobile = this.getSingleUserByMobile(userData);
		boolean singleUserByEmail = this.getSingleUserByEmail(userData);
		
		
		//password validation regex
        String regex = "^(?=.*[A-Z]{2})(?=.*[a-z]{2})(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{2})(?=.*\\d{2}).{8,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
//		condition to confirm
        if(matcher.matches()) {
        	//email validation regex
            regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(email);
            
	        if(matcher.matches()) {
	        	//mobile validation regex
                regex = "^[6-9]\\d{9}$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(mobile);
                
                if(matcher.matches()) {
					if (singleUserByEmail) {
						if (singleUserByMobile) {
							int insertUser = this.userDataDaoImpl.insertUser(userData);
							if (insertUser > 0)
								return "Signup Success full";
							else
								return "Something went Wrong!";
						} else {
							return "Mobile Number Aleardy Exist!";
						}
					} else {
						return "Email Aleardy Exist!";
					}
				} else {
					return "Mobile Number is Not Valid !";
				}
	        } else {
	        	return "Email is Not Valid !";
	        	
	        }
		} else {
			return "Password is Not Valid !";
		}
	}

	public int insertUserList(List<UserData> userDatas) {
		return this.userDataDaoImpl.insertUserList(userDatas);
	}
	
	public boolean updateUser(UserData userData) {
		return this.userDataDaoImpl.updateUser(userData);
	}
	public boolean deleteUser(UserData userData) {
		return this.userDataDaoImpl.deleteUser(userData);
	}
	public UserData getSingleUser(int userId) {
		return this.userDataDaoImpl.getSingleUser(userId);
	}
	public List<UserData> getListUser() {
		return this.userDataDaoImpl.getAllUser();
	}
	

	public boolean getSingleUserByMobile(UserData userData) {
		List<UserData> singleUserByMobile = this.userDataDaoImpl.getSingleUserByMobile(userData.getMobile());
		return singleUserByMobile.isEmpty();
	}
	
	public boolean getSingleUserWhereMobileIsNot(String mobile,String msId) {
		List<UserData> singleUserWhereMobileIsNot = this.userDataDaoImpl.getSingleUserWhereMobileIsNot(msId, mobile);
		if(singleUserWhereMobileIsNot.size()==0) {
			return true;
		}else
			return false;
	}
	public boolean getSingleUserWhereEmailIsNot(String email,String msId) {
		List<UserData> singleUserWhereMobileIsNot = this.userDataDaoImpl.getSingleUserWhereEmailIsNot(msId, email);
		if(singleUserWhereMobileIsNot.size()==0) {
			return true;
		}else
			return false;
	}

	public boolean getSingleUserByEmail(UserData userData) {
		List<UserData> singleUserByEmail = this.userDataDaoImpl.getSingleUserByEmail(userData.getEmail());
		return singleUserByEmail.isEmpty();
	}
	public boolean getSingleUserByEmail(String email,String msId) {
		List<UserData> singleUserByEmail = this.userDataDaoImpl.getSingleUserByEmail(email);
		System.out.println("singleUserByEmail "+singleUserByEmail);
		for(UserData data : singleUserByEmail); 
		if(userData.getMsId()!=msId) {
			return false;
		}
		return true;
	}
	public UserData getSingleUserByEmailAndMobile(String email,String mobile) {
		List<UserData> singleUserByEmailAndMobile = this.userDataDaoImpl.getSingleUserByEmailAndMobile(email, mobile);
		System.out.println();
		for(UserData userData : singleUserByEmailAndMobile) {
			if(userData!=null) {
				return userData;
			}
		}
		return null;
	}
	public UserData getSingleUserByMsId(String msId) {
		return this.userDataDaoImpl.getSingleUserByMsId(msId);
	}
	
}
