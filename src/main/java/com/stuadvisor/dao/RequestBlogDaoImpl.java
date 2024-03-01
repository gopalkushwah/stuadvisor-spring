package com.stuadvisor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.RequestBlogData;

@Repository
public class RequestBlogDaoImpl implements  RequestBlogDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Query<RequestBlogData> getQuery(String hql){
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql,RequestBlogData.class);
	}

	@Transactional
	@Override
	public int insertRequestBlog(RequestBlogData requestBlogData) {
		try {
			return (Integer)this.hibernateTemplate.save(requestBlogData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Transactional
	@Override
	public int insertRequestBlogList(List<RequestBlogData> blogDatas) {
		int save = 0;
		try {
			for(RequestBlogData requestBlogData : blogDatas) 
					save = (Integer)this.hibernateTemplate.save(requestBlogData);
			
			return save;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Transactional
	@Override
	public RequestBlogData getSingleRequestBlogData(int requestBlogId) {
		try {
			return this.hibernateTemplate.get(RequestBlogData.class, requestBlogId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public boolean updateRequestBlogData(RequestBlogData requestBlogData) {
		try {
			this.hibernateTemplate.update(requestBlogData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteRequestBlogData(RequestBlogData requestBlogData) {
		try {
			this.hibernateTemplate.delete(requestBlogData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	@Override
	public List<RequestBlogData> getRequestBlogDataList() {
		try {
			String hql = "FROM RequestBlogData r ORDER BY r.id DESC ";
			Query<RequestBlogData> query = this.getQuery(hql);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
