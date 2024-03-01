package com.stuadvisor.dao;

import java.util.List;

import com.stuadvisor.model.StudyMaterialData;

public interface StudyMaterialDao {
	public int insertStudyMaterial(StudyMaterialData studyMaterialData);
	public int insertStudyMaterialList(List<StudyMaterialData> studyMaterialDatas);
	public boolean updateStudyMaterial(StudyMaterialData studyMaterialData);
	public boolean deleteStudyMaterial(StudyMaterialData studyMaterialData);
	public StudyMaterialData getSingleStudyMaterial(int studyMaterialId);
	public List<StudyMaterialData> getAllStudyMaterial();
	public List<StudyMaterialData> getAllStudyMaterial(String title);
}
