package com.stuadvisor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TopCollegesData {
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
	
	public TopCollegesData() {
		
	}
	public TopCollegesData(String title, String logo, String location, String url, String reviews, String rating,
			String fee, String course) {
		super();
		this.title = title;
		this.logo = logo;
		this.location = location;
		this.url = url;
		this.reviews = reviews;
		this.rating = rating;
		this.fee = fee;
		this.course = course;
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
	
	@Override
	public String toString() {
		return "CollegesData [title=" + title + ", logo=" + logo + ", location=" + location + ", url=" + url
				+ ", reviews=" + reviews + ", rating=" + rating + ", fee=" + fee + ", course=" + course + "]";
	}
	
}
