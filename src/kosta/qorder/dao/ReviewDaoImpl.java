package kosta.qorder.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.Review;

@Repository("reviewDao")
public class ReviewDaoImpl implements ReviewDao
{
	private SqlSessionTemplate session;
	public ReviewDaoImpl(){}
	@Autowired
	public ReviewDaoImpl(SqlSessionTemplate session)
	{
		this.session=session;
	}
	@Override
	public int insertReview(Review review)
	{
		return session.insert("reviewMapper.insertReview",review);
	}

	@Override
	public int deleteReviewById(int reviewId)
	{
		return session.delete("reviewMapper.deleteReviewById",reviewId);
	}

	@Override
	public int updateReviewById(Review review)
	{
		return session.update("reviewMapper.updateReviewById",review);
	}

	@Override
	public List<Review> selectReviews()
	{
		return session.selectList("reviewMapper.selectReview");
	}
	
	@Override
	public Review selectReviewById(int reviewId)
	{
		return session.selectOne("reviewMapper.selectReviewById",reviewId);
	}
	public List<Review> selectReviewByItemId(int itemId)
	{
		return session.selectList("reviewMapper.selectReviewByItemId",itemId);
	}
	@Override
	public List<Review> selectReviewsByName(String reviewName)
	{
		return session.selectList("reviewMapper.selectReviewByName",reviewName);
	}
	@Override
	public List<Review> selectReviewPaging(int pageNo, int restaurantId) {
		
		HashMap parameter = new HashMap();
		parameter.put("contentPerPage", PagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		parameter.put("restaurantId", restaurantId);
		
		return session.selectList("reviewMapper.selectReviewPaging", parameter);
		
	}
	@Override
	public int reviewCountByitemId(int restaurantId) {
		
		// TODO Auto-generated method stub
		return session.selectOne("reviewMapper.reviewCountByitemId", restaurantId);
	
	}
	
	public List<Review> selectReviewByCustomerId(String customerId)
	{
		return session.selectList("selectReviewByCustomerId",customerId);
	}
	
}
