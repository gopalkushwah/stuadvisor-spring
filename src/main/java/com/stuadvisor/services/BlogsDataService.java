package com.stuadvisor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.stuadvisor.dao.BlogsDataDao;
import com.stuadvisor.model.BlogsData;

@Service
public class BlogsDataService {

	@Autowired
	private BlogsDataDao blogsDataDaoImpl;

	public BlogsDataDao getBlogsDataDaoImpl() {
		return blogsDataDaoImpl;
	}

	public void setBlogsDataDaoImpl(BlogsDataDao blogsDataDaoImpl) {
		this.blogsDataDaoImpl = blogsDataDaoImpl;
	}
	
//	******************* *********************************************
	public int insertBlogs(BlogsData blogs) {
		return this.blogsDataDaoImpl.insertBlogs(blogs);
	}
	
	public int insertBlogsList(List<BlogsData> blogs) {
		return this.blogsDataDaoImpl.insertBlogsList(blogs);
	}
	
	public BlogsData getSingleBlog(int blogId) {
		return this.blogsDataDaoImpl.getSingleBlogs(blogId);
	}
	
	public List<BlogsData> getAllBlog() {
		return this.blogsDataDaoImpl.getAllBlogs();
	}
	
	public boolean updateBlog(BlogsData blogsData) {
		return this.blogsDataDaoImpl.updateBlogs(blogsData);
	}
	public boolean deleteBlog(BlogsData blogsData) {
		return this.blogsDataDaoImpl.deleteBlogs(blogsData);
	}
	
	public String getEducationalBlog(String title) {
		List<BlogsData> educationalBlog = this.blogsDataDaoImpl.getEducationalBlogsByTitle(title);
		Gson gson = new Gson();
		String json = gson.toJson(educationalBlog);
		return json;
	}
	public String getAnyEducationalBlog(String title) {
		List<BlogsData> allBlog = this.blogsDataDaoImpl.getAnyEducationalBlogsByTitle(title);
		Gson gson = new Gson();
		String json = gson.toJson(allBlog);
		return json;
	}
	public String getOtherBlog(String title) {
		List<BlogsData> allBlog = this.blogsDataDaoImpl.getOtherBlogsByTitle(title);
		Gson gson = new Gson();
		String json = gson.toJson(allBlog);
		return json;
	}
	
	public BlogsData getLastRow() {
		return this.blogsDataDaoImpl.getLastRow();
	}
	
	public void getBlogsByUserId(String userId,String filename) {
		List<BlogsData> blogsByUserId = this.blogsDataDaoImpl.getBlogsByUserId(userId);
		List<BlogsData> blogsList = new ArrayList<>();
		for(BlogsData blogsData : blogsByUserId) {
			blogsData.setUserProfileImage(filename);
			blogsList.add(blogsData);
		}
		this.blogsDataDaoImpl.updateBlogsList(blogsList);
	}
}
