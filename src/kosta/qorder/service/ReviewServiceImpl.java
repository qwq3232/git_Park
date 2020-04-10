package kosta.qorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.qorder.dao.ReviewDao;
import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.Review;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService
{
	private ReviewDao dao;
	public ReviewServiceImpl(){}
	@Autowired
	public ReviewServiceImpl(ReviewDao dao)
	{
		this.dao=dao;
	}
	@Override
	public void addReview(Review review)
	{
		dao.insertReview(review);
	}

	@Override
	public void removeReviewById(int reviewId)
	{
		dao.deleteReviewById(reviewId);
	}

	@Override
	public void updateReviewById(Review review)
	{
		dao.updateReviewById(review);
	}

	@Override
	public List<Review> getAllReviews()
	{
		return dao.selectReviews();
	}

	@Override
	public Review getReviewById(int reviewId)
	{
		return dao.selectReviewById(reviewId);
	}
	public List<Review> getReviewByItemId(int itemId)
	{
		return dao.selectReviewByItemId(itemId);
	}
	@Override
	public List<Review> getReviewsByName(String reviewName)
	{
		return dao.selectReviewsByName(reviewName);
	}
	
	@Override
	public Map getReviewByPaging(int pageNo, int restaurantId) {
		
		HashMap map = new HashMap();
		
		List<Review> review_list = dao.selectReviewPaging(pageNo, restaurantId);
		map.put("list", review_list);
	
		int reviewCount = getReviewByitemId(restaurantId);
		PagingBean pagingBean = new PagingBean(reviewCount, pageNo);
		map.put("paging", pagingBean);
		
		return map;
		
	}
	
	@Override
	public int getReviewByitemId(int restaurantId) {
		
	    // TODO Auto-generated method stub
		return dao.reviewCountByitemId(restaurantId);
		
	}
	
	public List<Review> getReviewsByCustomerId(String customerId)
	{
		return dao.selectReviewByCustomerId(customerId);
	}
	
}
