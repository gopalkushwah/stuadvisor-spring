package com.stuadvisor.dao;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.stuadvisor.model.ReviewsData;

@Repository
public class ReviewsDaoImpl implements ReviewsDao{
	
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
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(ReviewsData.class);
	}
	public Query<ReviewsData> getQuery(String hql) {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql,ReviewsData.class);
	}

	
	@Transactional
	@Override
	public int insertReviews(ReviewsData reviewData) {
		try {
			return (Integer)this.hibernateTemplate.save(reviewData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Transactional
	@Override
	public int insertReviewsList(List<ReviewsData> reviewDatas) {
		int save = 0;
		try {
			for(ReviewsData reviewData : reviewDatas)
				save =  (Integer)this.hibernateTemplate.save(reviewData);
			return save;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return save;
	}

	@Transactional
	@Override
	public boolean updateReviews(ReviewsData reviewData) {
		try {
			this.hibernateTemplate.saveOrUpdate(reviewData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteReviews(ReviewsData reviewData) {
		try {
			this.hibernateTemplate.delete(reviewData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	@Override
	public ReviewsData getSingleReviews(int reviewId) {
		try {
			return this.hibernateTemplate.get(ReviewsData.class,reviewId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<ReviewsData> getAllReviews() {
		try {
			return this.hibernateTemplate.loadAll(ReviewsData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<ReviewsData> getTopReviews() {
		try {
			String hql = "FROM ReviewsData r WHERE r.stars = :starValue ORDER BY RAND()";
			Query<ReviewsData> query = this.getQuery(hql);
			query.setParameter("starValue", "5 stars");
			List<ReviewsData> list = query.setMaxResults(4).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
