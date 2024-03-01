package com.stuadvisor.dao;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.CollegesData;

@Repository
public class CollegesDataDaoImpl implements CollegesDataDao{

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
	public int insertCollege(CollegesData collegesData) {
		return (Integer)this.hibernateTemplate.save(collegesData);
	}

	@Transactional
	@Override
	public int insertCollegeList(List<CollegesData> collegesDataList) {
		try {
			for(CollegesData collegesData : collegesDataList)
				this.hibernateTemplate.saveOrUpdate(collegesData);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	@Override
	public boolean updateCollege(CollegesData collegesData) {
		try {
			this.hibernateTemplate.saveOrUpdate(collegesData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Transactional
	@Override
	public boolean deleteCollege(CollegesData collegesData) {
		try {
			this.hibernateTemplate.delete(collegesData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public CollegesData getSingleCollege(int collegesDataId) {
		return this.hibernateTemplate.get(CollegesData.class,collegesDataId);
	}

	@Override
	public List<CollegesData> getAllCollege() {
		return this.hibernateTemplate.loadAll(CollegesData.class);
	}

	@Transactional
	@Override
	public List<CollegesData> searchByCity(String city) {
		try {
			Criteria createCriteria = this.getCriteria();
			createCriteria.add(Restrictions.eq("city", city));
	        List<CollegesData> colleges = createCriteria.list();
			return colleges;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<CollegesData> searchByState(String state) {
		try {
			Criteria createCriteria = this.getCriteria();
			createCriteria.add(Restrictions.eq("state", state));
	        List<CollegesData> colleges = createCriteria.list();
			return colleges;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<CollegesData> searchByCourse(String course) {
		try {
			Criteria createCriteria = this.getCriteria();
			createCriteria.add(Restrictions.eq("course", course));
	        List<CollegesData> colleges = createCriteria.list();
			return colleges;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public Set<String> getCourseName() {
		try {
			Criteria createCriteria = this.getCriteria();
			createCriteria.setProjection(Projections.property("course"));
			List<String> courseList = createCriteria.list();
			Set<String> set = new HashSet<>();
			for(String str : courseList) {
				set.add(str);
			}
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<CollegesData> searchAllTypeCollege(String city, String state, String course) {
		try {
			Query createQuery = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("FROM CollegesData c WHERE c.city=:x OR c.state = :y OR c.course = :z");
			createQuery.setParameter("x", city);
			createQuery.setParameter("y", state);
			createQuery.setParameter("z", course);
			
			List<CollegesData> list = createQuery.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
