package com.stuadvisor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = true)
	private String course;
	@Column(nullable = true)
	private String branch;
	@Column(nullable = true)
	private String sem;
	@Column(nullable = true)
	private String subject;
	@Column(nullable = true)
	private String impque;
	@Column(nullable = true)
	private String sample;
	@Column(nullable = true)
	private String prepaper;
	
	public CourseData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseData(int id, String course, String branch, String sem, String subject, String impque, String sample,
			String prepaper) {
		super();
		this.id = id;
		this.course = course;
		this.branch = branch;
		this.sem = sem;
		this.subject = subject;
		this.impque = impque;
		this.sample = sample;
		this.prepaper = prepaper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getImpque() {
		return impque;
	}

	public void setImpque(String impque) {
		this.impque = impque;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getPrepaper() {
		return prepaper;
	}

	public void setPrepaper(String prepaper) {
		this.prepaper = prepaper;
	}

	@Override
	public String toString() {
		return "CourseData [id=" + id + ", course=" + course + ", branch=" + branch + ", sem=" + sem + ", subject="
				+ subject + ", impque=" + impque + ", sample=" + sample + ", prepaper=" + prepaper + "]";
	}
	
	
}
