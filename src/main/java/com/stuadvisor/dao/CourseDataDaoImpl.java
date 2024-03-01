package com.stuadvisor.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.stuadvisor.model.CourseData;

@Repository
public class CourseDataDaoImpl implements CourseDataDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
//	******************** SETTERS AND GETTERS FOR hibernateTemplate
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

//	********** TO GET createCriteria FOR CouserData.class
	public Criteria getCriteria() {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(CourseData.class);
	}
	
	
//	********************** INSERT SINGLE ENTITY *****************************
	@Transactional
	@Override
	public int insertCourse(CourseData courseData) {
		int save = (Integer)this.hibernateTemplate.save(courseData);
		return save;
	}

//	********************** INSERT LIST OF ENTITIES *****************************
	@Transactional
	@Override
	public int insertCourseList(List<CourseData> courseDatas) {
		int save = 0;
		try {
			for(CourseData courseData : courseDatas) {
				 save = (Integer)this.hibernateTemplate.save(courseData);
			}
			return save;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

//	********************** UPDATE AN ENTITY *****************************
	@Transactional
	@Override
	public boolean updateCourse(CourseData courseData) {
		try {
			this.hibernateTemplate.saveOrUpdate(courseData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	********************** UPDATE AN ENTITY *****************************
	@Transactional
	@Override
	public boolean deleteCourse(CourseData courseData) {
		try {
			this.hibernateTemplate.delete(courseData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	********************** GET AN SINGLE ENTITY BY ITS ID *****************************
	@Transactional
	@Override
	public CourseData getSingleCourse(int courseId) {
		try {
			return this.hibernateTemplate.get(CourseData.class,courseId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	********************** GET LIST OF ALL ENTITY *****************************
	@Transactional
	@Override
	public List<CourseData> getAllCourse() {
		return this.hibernateTemplate.loadAll(CourseData.class);
	}

//	********************** GET All Course Name *****************************
	@Transactional
	@Override
	public Set<String> getCourseName() {
		Set<String> set = new HashSet<>();
		try {
			Criteria createCriteria = this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(CourseData.class);
			createCriteria.setProjection(Projections.property("course"));
			List<String> list = createCriteria.list();
			if(!list.isEmpty()) {
				for(String str : list) {
					set.add(str);
				}
			}
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	********************** GET All Branch Name *****************************
	@Transactional
	@Override
	public Set<String> getBranchesName(String course) {
		Set<String> set = new HashSet<>();
	try {

		Criteria createCriteria = this.getCriteria();
		createCriteria.add(Restrictions.eq("course", course));
		createCriteria.setProjection(Projections.property("branch"));
		List<String> list = createCriteria.list();
		for(String str : list) {
			set.add(str);
		}
		return set;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}

//	********************** GET All Courses LIST  *****************************
	@Transactional
	@Override
	public List<CourseData> getAllCourses(String course) {
		try {
			Criteria createCriteria = this.getCriteria();
			createCriteria.add(Restrictions.eq("course", course));
			List<CourseData> list = createCriteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	********************** GET All Semester Name *****************************
	@Transactional
	@Override
	public Set<String> getSemName(String course,String branch) {
		Set<String> set = new HashSet<>();
		try {
			Criteria criteria = this.getCriteria();
			criteria.add(Restrictions.and(
					Restrictions.eq("branch", branch),
					Restrictions.eq("course", course)
					));
			criteria.setProjection(Projections.property("sem"));
			List<String> list = criteria.list();
			for(String str : list) {
				set.add(str);
			}
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	********************** GET All Subjects Name *****************************
//	********************** GET All Subjects Name *****************************
	@Transactional
	@Override
	public List<CourseData> getSubName(String course, String branch, String sem) {
		try {
			Criteria criteria = this.getCriteria();
			criteria.add(Restrictions.and(
					Restrictions.eq("branch", branch),
					Restrictions.eq("course", course),
					Restrictions.eq("sem", sem)
					));
			
			criteria.setProjection(Projections.projectionList()
		            .add(Projections.property("subject"))
		            .add(Projections.property("impque"))
		        );
			List<CourseData> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	********************** GET All Important Questions Url *****************************
	@Transactional
	@Override
	public List<CourseData> getImpName(String course, String branch, String sem) {
		try {
			Criteria criteria = this.getCriteria();
			criteria.add(Restrictions.and(
					Restrictions.eq("branch", branch),
					Restrictions.eq("course", course),
					Restrictions.eq("sem", sem)
					));
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("subject"))
					.add(Projections.property("impque"))
					);
			List<CourseData> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	********************** GET All Previous Year Paper Url *****************************
	@Transactional
	@Override
	public List<CourseData> getPaperName(String course, String branch, String sem) {
		try {
			Criteria criteria = this.getCriteria();
			criteria.add(Restrictions.and(
					Restrictions.eq("branch", branch),
					Restrictions.eq("course", course),
					Restrictions.eq("sem", sem)
					));
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("subject"))
					.add(Projections.property("prepaper"))
					);
			List<CourseData> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	********************** GET All Sample Papers Url *****************************
	@Transactional
	@Override
	public List<CourseData> getSampleName(String course, String branch, String sem) {
		try {
			Criteria criteria = this.getCriteria();
			criteria.add(Restrictions.and(
					Restrictions.eq("branch", branch),
					Restrictions.eq("course", course),
					Restrictions.eq("sem", sem)
					));
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("subject"))
					.add(Projections.property("sample"))
					);
			List<CourseData> list = criteria.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
