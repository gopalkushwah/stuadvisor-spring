package com.stuadvisor.model;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BlogsData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String htmlId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String category;
	
	@Column(nullable = false)
	private String postBy;
	
	@Column(nullable = false)
	private String userProfileImage;
	
	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false, columnDefinition = "LONGTEXT")
	private String description;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date postCreation;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date postUpdation;
	
	public BlogsData() {
		
	}
	public BlogsData(int id, String htmlId, String title, String category, String postBy, String userProfileImage,
			String userId, String description, Date postCreation, Date postUpdation) {
		super();
		this.id = id;
		this.htmlId = htmlId;
		this.title = title;
		this.category = category;
		this.postBy = postBy;
		this.userProfileImage = userProfileImage;
		this.userId = userId;
		this.description = description;
		this.postCreation = postCreation;
		this.postUpdation = postUpdation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHtmlId() {
		return htmlId;
	}
	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "BlogsData [id=" + id + ", htmlId=" + htmlId + ", title=" + title + ", category=" + category
				+ ", postBy=" + postBy + ", userProfileImage=" + userProfileImage + ", userId=" + userId
				+ ", description=" + description + ", postCreation=" + postCreation + ", postUpdation=" + postUpdation
				+ "]";
	}
}
