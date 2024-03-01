package com.stuadvisor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.stuadvisor.model.StudyMaterialData;
import com.stuadvisor.services.StudyMaterialServices;

@Controller
public class StudyMaterialController {

	@Autowired
	private StudyMaterialData studyMaterialData;
	
	@Autowired
	private StudyMaterialServices studyMaterialServices;
	
	@RequestMapping(path = "/set-study-material",method = RequestMethod.POST)
	public ResponseEntity<String> insertStudyMaterial(
				@RequestParam("fileData") CommonsMultipartFile file,
				HttpSession session,
				@RequestParam("title") String title,
				@RequestParam("description") String description,
				@RequestParam("createrId") String createrId,
				@RequestParam("createrImage") String createrImage,
				@RequestParam("createrName") String createrName
			) {
		
		String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
		studyMaterialData.setCreaterId(createrId);
		studyMaterialData.setCreaterImage(createrImage);
		studyMaterialData.setCreaterName(createrName);
		studyMaterialData.setDescription(description);
		studyMaterialData.setTitle(title);
		studyMaterialData.setStudyMaterialImage(fileName);
		
		
		String insertStudyMaterial = this.studyMaterialServices.insertStudyMaterial(studyMaterialData, file, session);
		return ResponseEntity.ok(insertStudyMaterial);
	}
}
