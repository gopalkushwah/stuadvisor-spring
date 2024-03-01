package com.stuadvisor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stuadvisor.dao.ContactUsDao;
import com.stuadvisor.model.ContactUsData;

@Service
public class ContactUsService {

	@Autowired
	private ContactUsDao contactUsDaoImpl;

	public ContactUsDao getContactUsDaoImpl() {
		return contactUsDaoImpl;
	}

	public void setContactUsDaoImpl(ContactUsDao contactUsDaoImpl) {
		this.contactUsDaoImpl = contactUsDaoImpl;
	}
	
	public int insertMessage(ContactUsData contactUsData) {
			return this.contactUsDaoImpl.insertMessage(contactUsData);
		
	}
	
}
