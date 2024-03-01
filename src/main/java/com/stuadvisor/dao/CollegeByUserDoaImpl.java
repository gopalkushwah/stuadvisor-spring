package com.stuadvisor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.CollegeByUserData;
import com.stuadvisor.model.CollegesData;

@Repository
public class CollegeByUserDoaImpl implements CollegeByUserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

//	********** TO GET createCriteria FOR CouserData.class
	public Criteria getCriteria() {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(CollegesData.class);
	}

	@Transactional
	@Override
	public int insertCollegeByUser(CollegeByUserData collegeByUserData) {
		return (Integer)this.hibernateTemplate.save(collegeByUserData);
	}

	@Transactional
	@Override
	public int insertCollegeByUserList(List<CollegeByUserData> collegeByUserDataList) {
		try {
			for(CollegeByUserData collegesData : collegeByUserDataList)
				this.hibernateTemplate.saveOrUpdate(collegesData);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	@Override
	public boolean updateCollegeByUser(CollegeByUserData collegeByUserData) {
		try {
			this.hibernateTemplate.saveOrUpdate(collegeByUserData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	@Override
	public boolean deleteCollegeByUser(CollegeByUserData collegeByUserData) {
		try {
			this.hibernateTemplate.delete(collegeByUserData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	@Override
	public CollegeByUserData getSingleCollege(int collegeByUserDataId) {
		return this.hibernateTemplate.get(CollegeByUserData.class,collegeByUserDataId);
	}

}
