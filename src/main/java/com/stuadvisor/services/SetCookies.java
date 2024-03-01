package com.stuadvisor.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stuadvisor.model.BlogsData;
import com.stuadvisor.model.UserData;

public class SetCookies {

	static Gson gson = new Gson();

	public static void setUserCookies(String name, UserData data, HttpServletResponse response) {
		setAllCookies(name, gson.toJson(data), response);
	}

	public static void setBlogsCookies(String name, BlogsData data, HttpServletResponse response) {
		setAllCookies(name, gson.toJson(data), response);
	}

	public static void setAllCookies(String name, String value, HttpServletResponse response) {
		try {
			String encodedCookieName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
			String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
			Cookie cookie = new Cookie(encodedCookieName, encodedValue);
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
//	get 
	
	public static UserData getUserCookie(String cookieName, HttpServletRequest request) {
		String normalCookies = getNormalCookies(cookieName, request);
		UserData fromJson = gson.fromJson(normalCookies, UserData.class);
		return fromJson;
	}
	
	public static String getNormalCookies(String cookieName, HttpServletRequest request) {
		String cookieContent = null;
		try {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookieName.equals(cookie.getName())) {
						cookieContent = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.toString());
						break;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookieContent;
	}
	
	
	
//	delete
	public static boolean deleteCookies(String cookieName, HttpServletRequest request, HttpServletResponse response) {
		boolean isDeleted = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookieName.equals(cookie.getName())) {
					cookie.setMaxAge(0); // Set the cookie's expiration time to 0 (in the past)
					response.addCookie(cookie); // Add the modified cookie to the response
					isDeleted = true;
					break; // No need to continue searching for the cookie
				}
			}
		}
		return isDeleted;
	}

}
