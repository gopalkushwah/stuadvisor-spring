package com.stuadvisor.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.UserData;

@Repository
public class UserDataDaoImpl implements UserDataDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Query<UserData> getQuery(String hql) {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql, UserData.class);
	}

	public Criteria getCriteria() {
		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UserData.class);
	}

	@Transactional
	@Override
	public int insertUser(UserData userData) {
		try {
			return (Integer) this.hibernateTemplate.save(userData);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	@Override
	public int insertUserList(List<UserData> userDatas) {
		int save = 0;
		try {
			for (UserData userData : userDatas)
				save = (Integer) this.hibernateTemplate.save(userData);
			return save;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Transactional
	@Override
	public boolean updateUser(UserData userData) {
		try {
			this.hibernateTemplate.saveOrUpdate(userData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteUser(UserData userData) {
		try {
			this.hibernateTemplate.delete(userData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public UserData getSingleUser(int userId) {
		try {
			return this.hibernateTemplate.get(UserData.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<UserData> getAllUser() {
		try {
			return this.hibernateTemplate.loadAll(UserData.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<UserData> getSingleUserByMobile(String mobile) {
		try {
			String hql = "FROM UserData WHERE mobile = :mobileValue";
			Query<UserData> query = this.getQuery(hql);
			query.setParameter("mobileValue", mobile);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<UserData> getSingleUserByEmail(String email) {
		try {
			String hql = "FROM UserData WHERE email = :emailValue";
			Query<UserData> query = this.getQuery(hql);
			query.setParameter("emailValue", email);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Transactional
	@Override
	public List<UserData> getSingleUserByEmailAndMobile(String email, String mobile) {

		try {
			String hql = "FROM UserData WHERE email = :emailValue AND mobile = :mobileValue";
			Query<UserData> query = this.getQuery(hql);
			query.setParameter("emailValue", email);
			query.setParameter("mobileValue", mobile);
			List<UserData> resultList = query.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public UserData getSingleUserByMsId(String msId) {
		try {
			String hql = "FROM UserData WHERE msId = :msIdvalue";
			Query<UserData> query = this.getQuery(hql);
			query.setParameter("msIdvalue", msId);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public List<UserData> getSingleUserWhereMobileIsNot(String msId,String mobile) {
		try {
			String hql = "FROM UserData u WHERE u.mobile = :mobileValue AND u.msId != :msIdValue";
			Query<UserData> query = this.getQuery(hql);
			query.setParameter("msIdValue", msId);
			query.setParameter("mobileValue", mobile);
			List<UserData> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Transactional
	@Override
	public List<UserData> getSingleUserWhereEmailIsNot(String msId,String email) {
		try {
			String hql = "FROM UserData u WHERE u.email = :emailValue AND u.msId != :msIdValue";
			Query<UserData> query = this.getQuery(hql);
			query.setParameter("msIdValue", msId);
			query.setParameter("emailValue", email);
			List<UserData> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
