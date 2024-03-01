package com.stuadvisor.dao;

import java.util.List;

import com.stuadvisor.model.ReviewsData;

public interface ReviewsDao {
	public int insertReviews(ReviewsData reviewData);
	public int insertReviewsList(List<ReviewsData> reviewDatas);
	public boolean updateReviews(ReviewsData reviewData);
	public boolean deleteReviews(ReviewsData reviewData);
	public ReviewsData getSingleReviews(int reviewId);
	public List<ReviewsData> getAllReviews();
	public List<ReviewsData> getTopReviews();
	
}
