package com.stuadvisor.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class StudyMaterialData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,name="title")
	private String title;
	
	@Column(nullable = false,name="description")
	private String description;
	
	@Column(nullable = false,name="creater_id")
	private String createrId;
	
	@Column(nullable = false,name="creater_image")
	private String createrImage;
	
	@Column(nullable = false,name="creater_name")
	private String createrName;
	
	@Column(nullable = false,name="study_material_image")
	private String studyMaterialImage;
	
	
	@Column(name="date_creation")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	
	@Column(name="date_updation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdatation;

	public StudyMaterialData() {
	}
	
	public StudyMaterialData(int id, String title, String description, String createrId, String createrImage,
			String createrName, Date dateCreation, Date dateUpdatation) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createrId = createrId;
		this.createrImage = createrImage;
		this.createrName = createrName;
		this.dateCreation = dateCreation;
		this.dateUpdatation = dateUpdatation;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCreaterImage() {
		return createrImage;
	}

	public void setCreaterImage(String createrImage) {
		this.createrImage = createrImage;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateUpdatation() {
		return dateUpdatation;
	}

	public void setDateUpdatation(Date dateUpdatation) {
		this.dateUpdatation = dateUpdatation;
	}

	public String getStudyMaterialImage() {
		return studyMaterialImage;
	}

	public void setStudyMaterialImage(String studyMaterialImage) {
		this.studyMaterialImage = studyMaterialImage;
	}

	@Override
	public String toString() {
		return "StudyMaterialData [id=" + id + ", title=" + title + ", description=" + description + ", createrId="
				+ createrId + ", createrImage=" + createrImage + ", createrName=" + createrName + ", dateCreation="
				+ dateCreation + ", dateUpdatation=" + dateUpdatation + "]";
	}
}
