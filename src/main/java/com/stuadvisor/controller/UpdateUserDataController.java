package com.stuadvisor.controller;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.stuadvisor.model.UserData;
import com.stuadvisor.services.BlogsDataService;
import com.stuadvisor.services.UserDatasService;

@Controller
public class UpdateUserDataController {

	@Autowired
	private UserDatasService userDatasService;
	
	@Autowired
	private BlogsDataService blogsDataService;

	@PostMapping("/edit-user-name")
	public ResponseEntity<String> editUserName(@RequestParam("name") String name, @RequestParam("msId") String msId) {
		UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
		singleUserByMsId.setName(name);
		boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
		if (updateUser)
			return ResponseEntity.ok("Your Name Updated");
		else
			return ResponseEntity.ok("Mobile Or Email Aleardy Exist!");
	}
	
	@PostMapping("/edit-user-address")
	public ResponseEntity<String> editUserAddress(@RequestParam("address") String address, @RequestParam("msId") String msId) {
		UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
		singleUserByMsId.setAddress(address);
		boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
		if (updateUser)
			return ResponseEntity.ok("Your Address Updated");
		else
			return ResponseEntity.ok("Mobile Or Email Aleardy Exist!");
	}
	@PostMapping("/edit-user-gender")
	public ResponseEntity<String> editUserGender(@RequestParam("gender") String gender, @RequestParam("msId") String msId) {
		UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
		singleUserByMsId.setGender(gender);
		boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
		if (updateUser)
			return ResponseEntity.ok("Your Gender Updated");
		else
			return ResponseEntity.ok("Mobile Or Email Aleardy Exist!");
	}
	@PostMapping("/change-user-password")
	public ResponseEntity<String> changeUserPassword(@RequestParam("password") String password, @RequestParam("msId") String msId) {
		UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
		String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
		singleUserByMsId.setPassword(hashpw);
		boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
		if (updateUser)
			return ResponseEntity.ok("Your Password has been Changed");
		else
			return ResponseEntity.ok("Something Went Wrong");
	}

	@PostMapping("/edit-user-mobile")
	public ResponseEntity<String> editUserMobile(@RequestParam("mobile") String mobile,
			@RequestParam("msId") String msId) {
		boolean singleUserByMobile = this.userDatasService.getSingleUserWhereMobileIsNot(mobile,msId);
		if (singleUserByMobile) {
			UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
			singleUserByMsId.setMobile(mobile);
			boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
			if (updateUser)
				return ResponseEntity.ok("Your Mobile Number is Updated");
			else
				return ResponseEntity.ok("Something went wrongk!");
		} else
			return ResponseEntity.ok("Mobile Number Aleardy Exist!");
	}
	
	@PostMapping("/edit-user-email")
	public ResponseEntity<String> editUserEmail(@RequestParam("email") String email,
			@RequestParam("msId") String msId) {
		boolean getSingleUserWhereEmailIsNot = this.userDatasService.getSingleUserWhereEmailIsNot(email,msId);
		if (getSingleUserWhereEmailIsNot) {
			UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
			singleUserByMsId.setEmail(email);
			boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
			if (updateUser)
				return ResponseEntity.ok("Your Email is Updated");
			else
				return ResponseEntity.ok("Something went wrongk!");
		} else
			return ResponseEntity.ok("Email Aleardy Exist!");
	}
	
	@PostMapping("/change-user-profile-img")
	public ResponseEntity<String> changeUserProfileImage(
			@RequestParam("fileData") CommonsMultipartFile file,
			HttpSession session,
			@RequestParam("msId") String msId) {
		
			String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
			
			UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(msId);
			this.blogsDataService.getBlogsByUserId(msId,fileName);
			singleUserByMsId.setProfileImage(fileName);
			if(((double) file.getSize() / (1024 * 1024)) <= 5) {
				String realPath = session.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"assets"+File.separator+"useruploads" + File.separator + fileName;
				byte[] bs = file.getBytes();
				try {
					boolean updateUser = this.userDatasService.updateUser(singleUserByMsId);
					
					if(updateUser) {
						FileOutputStream fos = new FileOutputStream(realPath);
						fos.write(bs);
						fos.close();
						return ResponseEntity.ok("Profile Image Updated");
					}else {
						return ResponseEntity.badRequest().body("Internal Server Error!");
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.badRequest().body("Something Went Wrong!");
				}
			}else {
				return ResponseEntity.badRequest().body("File size should be less then 5Mb ");
			}
			
			
			
			
	}
}
