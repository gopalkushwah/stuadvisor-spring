package com.stuadvisor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.TopCollegesData;

@Repository
public class TopCollegesDaoImpl implements TopCollegesDao{

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
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(TopCollegesData.class);
	}
	
	@Transactional
	@Override
	public int insertTopCollege(TopCollegesData topCollegesData) {
		int save = (Integer)this.hibernateTemplate.save(topCollegesData);
		return save;
	}

	@Transactional
	@Override
	public int insertTopCollegeList(List<TopCollegesData> topCollegesDatas) {
		int save = 0;
		try {
			for(TopCollegesData topCollegesData : topCollegesDatas) {
				System.out.println(topCollegesData);
				save = (Integer)this.hibernateTemplate.save(topCollegesData);
			}
			return save;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return save;
		}
	}

	@Transactional
	@Override
	public boolean updateTopCollege(TopCollegesData topCollegesData) {
		try {
			this.hibernateTemplate.saveOrUpdate(topCollegesData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteTopCollege(TopCollegesData topCollegesData) {
		try {
			this.hibernateTemplate.delete(topCollegesData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public TopCollegesData getSingleTopCollege(int topCollegeId) {
		try {
			TopCollegesData topCollegesData = this.hibernateTemplate.get(TopCollegesData.class,topCollegeId);
			return topCollegesData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TopCollegesData> getAllTopCollege() {
		try {
			List<TopCollegesData> topCollegesData = this.hibernateTemplate.loadAll(TopCollegesData.class);
			return topCollegesData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<TopCollegesData> getTopCollege(int page, int size) {
		try {
			Criteria criteria = this.getCriteria();
			criteria.setFirstResult(page * size);
			criteria.setMaxResults(size);
			criteria.addOrder(Order.asc("id"));
			List<TopCollegesData> list = (List<TopCollegesData>)criteria.list();
			System.out.println(list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	
}
