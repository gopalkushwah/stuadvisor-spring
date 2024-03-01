package com.stuadvisor.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuadvisor.dao.RequestBlogDao;
import com.stuadvisor.model.RequestBlogData;

@Service
public class RequestBlogService {

	@Autowired
	private RequestBlogDao requestBlogDaoImpl;

	public RequestBlogDao getRequestBlogDaoImpl() {
		return requestBlogDaoImpl;
	}

	public void setRequestBlogDaoImpl(RequestBlogDao requestBlogDaoImpl) {
		this.requestBlogDaoImpl = requestBlogDaoImpl;
	}

	public String insertRequestBlog(RequestBlogData requestBlogData) {
		int insertRequestBlog = this.requestBlogDaoImpl.insertRequestBlog(requestBlogData);

		if (insertRequestBlog > 0)
			return "Request Sent Successfuly";

		return "Something Went Wrong!";
	}

	public String insertRequestBlogList(List<RequestBlogData> blogDatas) {
		int insertRequestBlogList = this.requestBlogDaoImpl.insertRequestBlogList(blogDatas);
		if (insertRequestBlogList > 0)
			return "Data Inserted";

		return "Something Went Wrong!";
	}

	public RequestBlogData getSingleRequestBlogData(int requestBlogId) {
		return this.requestBlogDaoImpl.getSingleRequestBlogData(requestBlogId);
	}

	public boolean updateRequestBlogData(RequestBlogData requestBlogData) {
		return this.requestBlogDaoImpl.updateRequestBlogData(requestBlogData);

	}

	public boolean deleteRequestBlogData(RequestBlogData requestBlogData) {
		return this.requestBlogDaoImpl.deleteRequestBlogData(requestBlogData);
	}

	public List<RequestBlogData> getRequestBlogDataList() {
		return this.requestBlogDaoImpl.getRequestBlogDataList();
	}

}
