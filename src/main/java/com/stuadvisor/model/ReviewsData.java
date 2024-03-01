package com.stuadvisor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class ReviewsData {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String postBy;
	
	@Column(nullable = false)
	private String userProfileImage;
	
	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false, columnDefinition = "LONGTEXT")
	private String review;
	
	
	@Column(nullable = false)
	private String stars;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date postCreation;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date postUpdation;
	
	public ReviewsData() {
	}
	
	public ReviewsData(int id, String postBy, String userProfileImage, String userId, String review, String stars,
			Date postCreation, Date postUpdation) {
		super();
		this.id = id;
		this.postBy = postBy;
		this.userProfileImage = userProfileImage;
		this.userId = userId;
		this.review = review;
		this.stars = stars;
		this.postCreation = postCreation;
		this.postUpdation = postUpdation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostBy() {
		return postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	public String getUserProfileImage() {
		return userProfileImage;
	}

	public void setUserProfileImage(String userProfileImage) {
		this.userProfileImage = userProfileImage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public Date getPostCreation() {
		return postCreation;
	}

	public void setPostCreation(Date postCreation) {
		this.postCreation = postCreation;
	}

	public Date getPostUpdation() {
		return postUpdation;
	}

	public void setPostUpdation(Date postUpdation) {
		this.postUpdation = postUpdation;
	}

	@Override
	public String toString() {
		return "ReviewsData [id=" + id + ", postBy=" + postBy + ", userProfileImage=" + userProfileImage + ", userId="
				+ userId + ", review=" + review + ", stars=" + stars + ", postCreation=" + postCreation
				+ ", postUpdation=" + postUpdation + "]";
	}
	
	
}
