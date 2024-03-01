package com.stuadvisor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.StudyMaterialData;

@Repository
public class StudyMaterialDaoImpl implements StudyMaterialDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Query getQuery(String hql) {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
	}
	@Transactional
	@Override
	public int insertStudyMaterial(StudyMaterialData studyMaterialData) {
		try {
			return(Integer)this.hibernateTemplate.save(studyMaterialData);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	@Override
	public int insertStudyMaterialList(List<StudyMaterialData> studyMaterialDatas) {
		int save = 0;
		try {
			for(StudyMaterialData studyMaterialData : studyMaterialDatas)
				save = (Integer)this.hibernateTemplate.save(studyMaterialData);
			
			return save;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	@Override
	public boolean updateStudyMaterial(StudyMaterialData studyMaterialData) {
		try {
			this.hibernateTemplate.update(studyMaterialData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteStudyMaterial(StudyMaterialData studyMaterialData) {
		try {
			this.hibernateTemplate.delete(studyMaterialData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public StudyMaterialData getSingleStudyMaterial(int studyMaterialId) {
		try {
			return this.hibernateTemplate.get(StudyMaterialData.class, studyMaterialId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<StudyMaterialData> getAllStudyMaterial() {
		try {
			return this.hibernateTemplate.loadAll(StudyMaterialData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<StudyMaterialData> getAllStudyMaterial(String title) {
		try {
			String hql = "FROM StudyMaterialData WHERE title = :titleToSearch";
			Query query = this.getQuery(hql);
			query.setParameter("titleToSearch", title);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
