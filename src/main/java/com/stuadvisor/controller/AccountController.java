package com.stuadvisor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuadvisor.model.UserData;
import com.stuadvisor.services.SetCookies;
import com.stuadvisor.services.UserDatasService;

@Controller
public class AccountController {

	@Autowired
	private UserData userData;

	@Autowired
	private UserDatasService userDatasService;
	
	
	@RequestMapping(path = "/profile")
	public String profile(HttpServletRequest request,Model model) {
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null) {
			UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(userCookie.getMsId());
			singleUserByMsId.setPassword("");
			model.addAttribute("singleUserByMsId",singleUserByMsId);
			model.addAttribute("title","Profile");
			return "profile";
		}else {
			return "redirect:/login";
		}
		
	}

	@RequestMapping(path = "/signup")
	public String signUp(Model model) {
		model.addAttribute("title","Sign Up");
		return "signup";
	}

	@RequestMapping(path = "/login")
	public String login(Model model) {
		model.addAttribute("title","Sign In");
		return "login";
	}

	@RequestMapping(path = "/post-academics")
	public String postAcademics(Model model,HttpServletRequest request) {
		model.addAttribute("title","Post Academics");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null) {
			model.addAttribute("userCookie",userCookie);
			return "post-academics";
		}else {
			return "redirect:/login";
		}
	}

	@RequestMapping(path = "/post-blogs")
	public String postBlogs(Model model,HttpServletRequest request) {
		model.addAttribute("title","Post Blogs");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null) {
			model.addAttribute("userCookie",userCookie);
			return "post-blogs";
		}else {
			return "redirect:/login";
		}
	}

	@RequestMapping(path = "/send-reviews")
	public String postReviews(Model model,HttpServletRequest request) {
		model.addAttribute("title","Post Reviews");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null) {
			model.addAttribute("userCookie",userCookie);
			return "post-revies";
		}else {
			return "redirect:/login";
		}
	}

	@RequestMapping(path = "/add-colleges")
	public String addCollege(Model model,HttpServletRequest request) {
		model.addAttribute("title","Add Colleges");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null) {
			model.addAttribute("userCookie",userCookie);
			return "add-colleges";
		}else {
			return "redirect:/login";
		}
	}

	@RequestMapping(path = "/edit-profile")
	public String editProfile(Model model,HttpServletRequest request) {
		model.addAttribute("title","Edit Profile");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null) {
			UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(userCookie.getMsId());
			singleUserByMsId.setPassword("");
			model.addAttribute("singleUserByMsId",singleUserByMsId);
			return "edit-profile";
		}else {
			return "redirect:/login";
		}
			
		
	}
	@RequestMapping(path = "/request-for-blog")
	public String requestForBlog(Model model,HttpServletRequest request) {
		model.addAttribute("title","Request For Blog");
		UserData userCookie = SetCookies.getUserCookie("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request);
		if(userCookie!=null)
			model.addAttribute("userCookie",userCookie);
		
		return "request-for-blogs";
	}

	@RequestMapping(path = "/singup-user",method = RequestMethod.POST)
	public ResponseEntity<String> userSignUp(@RequestParam("address") String address, @RequestParam("name") String name,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("gender") String gender) {
		
//		Encrypting the password to hash value using BCrypt Library 
		String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
		
//		Setting values or RequestParam into UserData entity object
		userData.setAddress(address);
		userData.setEmail(email);
		userData.setMobile(mobile);
		userData.setPassword(hashpw);
		userData.setGender(gender);
		userData.setName(name);
		userData.setMsId(Long.toString(System.currentTimeMillis()));
		userData.setProfileImage("user.png");
		String insertUser = this.userDatasService.insertUser(userData, email, password, mobile);
		return ResponseEntity.ok(insertUser);

	}
	
	@RequestMapping(path ="/user-login",method = RequestMethod.POST)
	public ResponseEntity<String> userLogin(@RequestParam("mobile") String mobile ,@RequestParam("email") String email ,@RequestParam("password") String password,HttpServletResponse response,HttpSession session){
		UserData singleUserByEmailAndMobile = this.userDatasService.getSingleUserByEmailAndMobile(email, mobile);
		boolean checkpw = false;
		if(singleUserByEmailAndMobile!=null) {
			checkpw = BCrypt.checkpw(password, singleUserByEmailAndMobile.getPassword());
			singleUserByEmailAndMobile.setPassword("");
		}
		if(checkpw) {
			SetCookies.setUserCookies("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", singleUserByEmailAndMobile,response);
			return ResponseEntity.ok().body("Login Success full");
		}
		return ResponseEntity.badRequest().body("Invalid Credentials! try again");
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		boolean deleteCookies = SetCookies.deleteCookies("ehsk75jh5k5dfs5hjflsa75s4f5sd5f5", request, response);
		if(deleteCookies)
			return "redirect:/";
		else
			return "redirect:/profile";
	}
	
	@PostMapping("/confirm-password")
	public ResponseEntity<String> confirmPassword(@RequestParam("userId") String userId,@RequestParam("password") String password) {
		UserData singleUserByMsId = this.userDatasService.getSingleUserByMsId(userId);
		boolean checkpw = BCrypt.checkpw(password, singleUserByMsId.getPassword());
		if(checkpw)
			return ResponseEntity.ok("Password is Correct");
		else 
			return ResponseEntity.ok("Incorrect Password");
	}
	
	
	
	
	
}
