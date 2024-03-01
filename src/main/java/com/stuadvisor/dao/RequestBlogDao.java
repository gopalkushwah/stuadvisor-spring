package com.stuadvisor.dao;

import java.util.List;

import com.stuadvisor.model.RequestBlogData;

public interface RequestBlogDao {
	public int insertRequestBlog(RequestBlogData requestBlogData);
	public int insertRequestBlogList(List<RequestBlogData> blogDatas);
	public RequestBlogData getSingleRequestBlogData(int requestBlogId);
	public boolean updateRequestBlogData(RequestBlogData requestBlogData);
	public boolean deleteRequestBlogData(RequestBlogData requestBlogData);
	public List<RequestBlogData> getRequestBlogDataList();
}
