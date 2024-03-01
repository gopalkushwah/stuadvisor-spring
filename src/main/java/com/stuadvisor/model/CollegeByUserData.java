package com.stuadvisor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;

@Entity
@Scope("prototype")
public class CollegeByUserData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String  title;
	
	@Column(nullable = false)
	private String  logo;
	
	@Column(nullable = false)
	private String  location;
	
	@Column(nullable = false)
	private String  url;
	
	@Column(nullable = false)
	private String  reviews;
	
	@Column(nullable = false)
	private String  rating;
	
	@Column(nullable = false)
	private String  fee;
	
	@Column(nullable = false)
	private String  course;
	
	@Column(nullable = false)
	private String  city;
	
	@Column(nullable = false)
	private String  bycourse;
	
	@Column(nullable = false)
	private String  state;
	
	@Column(nullable = false)
	private String  userId;
	
	public CollegeByUserData() {
		
	}
	public CollegeByUserData(int id, String title, String logo, String location, String url, String reviews,
			String rating, String fee, String course, String city, String bycourse, String state, String userId) {
		super();
		this.id = id;
		this.title = title;
		this.logo = logo;
		this.location = location;
		this.url = url;
		this.reviews = reviews;
		this.rating = rating;
		this.fee = fee;
		this.course = course;
		this.city = city;
		this.bycourse = bycourse;
		this.state = state;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBycourse() {
		return bycourse;
	}
	public void setBycourse(String bycourse) {
		this.bycourse = bycourse;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CollegeByUserData [id=" + id + ", title=" + title + ", logo=" + logo + ", location=" + location
				+ ", url=" + url + ", reviews=" + reviews + ", rating=" + rating + ", fee=" + fee + ", course=" + course
				+ ", city=" + city + ", bycourse=" + bycourse + ", state=" + state +", userId=" + userId + "]";
	}

}
