package com.stuadvisor.model;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class RequestBlogData  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false)
	private String userImg;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	public RequestBlogData() {
	}
	
	public RequestBlogData(int id, String title, String userName, String userId, String userImg, Date creationDate) {
		super();
		this.id = id;
		this.title = title;
		this.userName = userName;
		this.userId = userId;
		this.creationDate = creationDate;
		this.userImg = userImg;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	@Override
	public String toString() {
		return "RequestBlogData [id=" + id + ", title=" + title + ", userName=" + userName + ", userId=" + userId
				+ ", creationDate=" + creationDate +  ", userImg=" + userImg + "]";
	}
	
	
}
