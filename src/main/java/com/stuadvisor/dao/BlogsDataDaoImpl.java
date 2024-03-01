package com.stuadvisor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.BlogsData;

@Repository
public class BlogsDataDaoImpl implements BlogsDataDao {

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
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(BlogsData.class);
	}
	public Query<BlogsData> getQuery(String hql) {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql,BlogsData.class);
	}

//	**********************  *********************************
	@Transactional
	@Override
	public int insertBlogs(BlogsData blogData) {
		try {
			return (Integer) this.hibernateTemplate.save(blogData);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
//	**********************  *********************************
	@Transactional
	@Override
	public int insertBlogsList(List<BlogsData> blogDatas) {
		int save = 0;
		try {
			for (BlogsData blogsData : blogDatas) {
				save = (Integer) this.hibernateTemplate.save(blogsData);
			}
			return save;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Transactional
	@Override
	public void updateBlogsList(List<BlogsData> blogDatas) {
		try {
			for (BlogsData blogsData : blogDatas)
				this.hibernateTemplate.update(blogsData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	**********************  *********************************
	@Transactional
	@Override
	public boolean updateBlogs(BlogsData blogData) {
		try {
			this.hibernateTemplate.saveOrUpdate(blogData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	**********************  *********************************
	@Transactional
	@Override
	public boolean deleteBlogs(BlogsData blogData) {
		try {
			this.hibernateTemplate.delete(blogData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	**********************  *********************************
	@Transactional
	@Override
	public BlogsData getSingleBlogs(int blogId) {
		try {
			return this.hibernateTemplate.get(BlogsData.class, blogId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	**********************  *********************************
	@Transactional
	@Override
	public List<BlogsData> getAllBlogs() {
		try {
			return this.hibernateTemplate.loadAll(BlogsData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	**********************  *********************************
	@Transactional
	@Override
	public List<BlogsData> getEducationalBlogsByTitle(String title) {
		try {
			String hql = "FROM BlogsData WHERE category = :categoryToSearch AND title LIKE :searchText";
			Query<BlogsData> query = this.getQuery(hql);
			query.setParameter("categoryToSearch", "education");
			query.setParameter("searchText", "%" + title + "%");
			List<BlogsData> resultList = query.list();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Transactional
	@Override
	public List<BlogsData> getAnyEducationalBlogsByTitle(String title) {
		try {
			String hql = "FROM BlogsData WHERE title LIKE :searchText";
			Query<BlogsData> query = this.getQuery(hql);
			
			query.setParameter("searchText", "%" + title + "%");
			
			List<BlogsData> resultList = query.list();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Transactional
	@Override
	public List<BlogsData> getOtherBlogsByTitle(String title) {
		try {
			String hql = "FROM BlogsData WHERE category != :categoryToSearch AND title LIKE :searchText";
			Query<BlogsData> query = this.getQuery(hql);
			query.setParameter("categoryToSearch", "education");
			query.setParameter("searchText", "%" + title + "%");
			
			List<BlogsData> resultList = query.list();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public BlogsData getLastRow() {
		try {
			String hql = "FROM BlogsData b ORDER BY b.id DESC";
			Query<BlogsData> query = this.getQuery(hql);
			return query.setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public List<BlogsData> getBlogsByUserId(String userId) {
		try {
			String hql = "FROM BlogsData b WHERE b.userId =:userIdValue";
			Query<BlogsData> query = this.getQuery(hql);
			query.setParameter("userIdValue", userId);
			List<BlogsData> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	

}
