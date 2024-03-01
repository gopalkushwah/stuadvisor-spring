package com.stuadvisor.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stuadvisor.model.ContactUsData;

@Repository
public class ContactUsDaoImpl implements ContactUsDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public int insertMessage(ContactUsData contactUsData) {
		try {
			return (Integer)this.hibernateTemplate.save(contactUsData);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
