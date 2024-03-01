package com.stuadvisor.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;

@Entity
@Scope("prototype")
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, name="ms_id")
	private String msId;
	
	@Column(nullable = false, name="name")
	private String name;
	
	@Column(nullable = false, name="email")
	private String email;
	
	@Column(nullable = false, name="mobile")
	private String mobile;
	
	@Column(nullable = false, name="address")
	private String address;
	
	@Column(nullable = false, name="password")
	private String password;
	
	@Column(name="profile_image")
	private String profileImage;
	
	@Column(name="gender",columnDefinition = "VARCHAR(255) DEFAULT 'user.jpg'")
	private String gender;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date signupDate;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date lastProfileUpdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsId() {
		return msId;
	}

	public void setMsId(String msId) {
		this.msId = msId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public Date getLastProfileUpdate() {
		return lastProfileUpdate;
	}

	public void setLastProfileUpdate(Date lastProfileUpdate) {
		this.lastProfileUpdate = lastProfileUpdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserData() {
		
	}
	
	
	public UserData(int id, String msId, String name, String email, String mobile, String address, String password,
			String profileImage, Date signupDate, Date lastProfileUpdate) {
		super();
		this.id = id;
		this.msId = msId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
		this.profileImage = profileImage;
		this.signupDate = signupDate;
		this.lastProfileUpdate = lastProfileUpdate;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", msId=" + msId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", password=" + password + ", profileImage=" + profileImage + ", signupDate="
				+ signupDate + ", lastProfileUpdate=" + lastProfileUpdate + "]";
	}
	
	
}
