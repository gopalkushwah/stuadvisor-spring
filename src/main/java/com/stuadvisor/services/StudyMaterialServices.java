package com.stuadvisor.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.stuadvisor.dao.StudyMaterialDao;
import com.stuadvisor.model.StudyMaterialData;

@Service
public class StudyMaterialServices {

	@Autowired
	private StudyMaterialDao studyMaterialDaoImpl;

	public StudyMaterialDao getStudyMaterialDaoImpl() {
		return studyMaterialDaoImpl;
	}

	public void setStudyMaterialDaoImpl(StudyMaterialDao studyMaterialDaoImpl) {
		this.studyMaterialDaoImpl = studyMaterialDaoImpl;
	}
	
	public String insertStudyMaterial(StudyMaterialData studyMaterialData,CommonsMultipartFile file,HttpSession session) {
		if(((double) file.getSize() / (1024 * 1024)) <= 5) {
			String realPath = session.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"assets"+File.separator+"studymaterialuploads" + File.separator + studyMaterialData.getStudyMaterialImage();
			byte[] bs = file.getBytes();
			try {
				int insertStudyMaterial = this.studyMaterialDaoImpl.insertStudyMaterial(studyMaterialData);
				if(insertStudyMaterial > 0) {
					FileOutputStream fos = new FileOutputStream(realPath);
					fos.write(bs);
					fos.close();
					return "Data Posted Succesfully";
				}else {
					return "Internal Server Error!";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "Something Went Wrong!";
			}
		}else {
			return "File size should be less then 5Mb ";
		}
	}
	
	
	public List<StudyMaterialData> getStudyMaterialDatas(){
		return this.studyMaterialDaoImpl.getAllStudyMaterial();
	}
}
