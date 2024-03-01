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

@Entity
public class ContactUsData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false,columnDefinition = "TEXT")
	private String message;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	private Date messageCreation;

	public ContactUsData() {
	}
	
	public ContactUsData(int id, String name, String email, String message, Date  messageCreation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.messageCreation =  messageCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getMessageCreation() {
		return messageCreation;
	}

	public void setMessageCreation(Date messageCreation) {
		this.messageCreation = messageCreation;
	}

	@Override
	public String toString() {
		return "ContactUsData [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message
				+ ", messageCreation =" + messageCreation + "]";
	}
	
	
}
