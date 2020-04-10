package kosta.qorder.service;

import java.util.List;
import java.util.Map;

import kosta.qorder.vo.Review;

public interface ReviewService
{
	void addReview(Review review);
	void removeReviewById(int reviewId);
	void updateReviewById(Review review);
	List<Review> getAllReviews();
	Review getReviewById(int reviewId);
	List<Review> getReviewByItemId(int itemId);
	List<Review> getReviewsByName(String reviewName);
	Map getReviewByPaging(int pageNo, int restaurantId);
	int getReviewByitemId(int restaurantId);
	List<Review> getReviewsByCustomerId(String customerId);
}
