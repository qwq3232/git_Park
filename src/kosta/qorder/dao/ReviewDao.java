package kosta.qorder.dao;

import java.util.List;

import kosta.qorder.vo.Item;
import kosta.qorder.vo.Review;

public interface ReviewDao
{
	int insertReview(Review review);
	int deleteReviewById(int reviewId);
	int updateReviewById(Review review);
	List<Review> selectReviews();
	Review selectReviewById(int reviewId);
	List<Review> selectReviewByItemId(int itemId);
	List<Review> selectReviewsByName(String reviewName);
	List<Review> selectReviewPaging(int pageNo, int restaurantId);
	int reviewCountByitemId(int restaurantId);
	List<Review> selectReviewByCustomerId(String customerId);

}
