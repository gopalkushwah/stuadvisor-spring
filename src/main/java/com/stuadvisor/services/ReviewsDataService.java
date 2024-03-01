package com.stuadvisor.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stuadvisor.dao.ReviewsDao;
import com.stuadvisor.model.ReviewsData;

@Service
public class ReviewsDataService {

	@Autowired
	private ReviewsDao reviewsDaoImpl;

	public ReviewsDao getReviewsDaoImpl() {
		return reviewsDaoImpl;
	}

	public void setReviewsDaoImpl(ReviewsDao reviewsDaoImpl) {
		this.reviewsDaoImpl = reviewsDaoImpl;
	}
	
	public int insertReviews(ReviewsData reviewData) {
		return this.reviewsDaoImpl.insertReviews(reviewData);
	}

	public int insertReviewsList(List<ReviewsData> reviewDatas) {
		return this.reviewsDaoImpl.insertReviewsList(reviewDatas);
			
	}

	public boolean updateReviews(ReviewsData reviewData) {
		return this.reviewsDaoImpl.updateReviews(reviewData);
	}

	public boolean deleteReviews(ReviewsData reviewData) {
		return this.reviewsDaoImpl.deleteReviews(reviewData);
	}

	public ReviewsData getSingleReviews(int reviewId) {
		return this.reviewsDaoImpl.getSingleReviews(reviewId);
	}

	public List<ReviewsData> getAllReviews() {
			return this.reviewsDaoImpl.getAllReviews();
	}
	
	public List<ReviewsData> getTopReviews() {
		return this.reviewsDaoImpl.getTopReviews();
	}
}
