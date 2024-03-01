package com.stuadvisor.dao;

import java.util.List;

import com.stuadvisor.model.BlogsData;

public interface BlogsDataDao {
	public int insertBlogs(BlogsData blogData);
	public int insertBlogsList(List<BlogsData> blogDatas);
	public boolean updateBlogs(BlogsData blogData);
	public boolean deleteBlogs(BlogsData blogData);
	public BlogsData getSingleBlogs(int blogId);
	public List<BlogsData> getAllBlogs();
	public List<BlogsData> getEducationalBlogsByTitle(String title);
	public List<BlogsData> getAnyEducationalBlogsByTitle(String title);
	public List<BlogsData> getOtherBlogsByTitle(String title);
	public List<BlogsData> getBlogsByUserId(String userId);
	public void updateBlogsList(List<BlogsData> blogDatas);
	public BlogsData getLastRow();
	
}
