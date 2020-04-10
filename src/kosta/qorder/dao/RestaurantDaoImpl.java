package kosta.qorder.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Restaurant;

@Repository("restaurantDao")
public class RestaurantDaoImpl implements RestaurantDao
{
	private SqlSessionTemplate session;
	public RestaurantDaoImpl(){}
	@Autowired
	public RestaurantDaoImpl(SqlSessionTemplate session)
	{
		this.session=session;
	}
	@Override
	public int insertRestaurant(Restaurant restaurant)
	{
		return session.insert("restaurantMapper.insertRestaurant",restaurant);
	}

	@Override
	public int deleteRestaurantById(int restaurantId)
	{
		return session.delete("restaurantMapper.deleteRestaurantById",restaurantId);
	}

	@Override
	public int updateRestaurantById(Restaurant restaurant)
	{
		return session.update("restaurantMapper.updateRestaurantById",restaurant);
	}

	@Override
	public List<Restaurant> selectRestaurants()
	{
		return session.selectList("restaurantMapper.selectRestaurants");
	}
	@Override
	public Restaurant selectRestaurantById(int restaurantId)
	{
		return session.selectOne("restaurantMapper.selectRestaurantById",restaurantId);
	}
	@Override
	public Restaurant selectRestaurantByOwnerId(String ownerId)
	{
		return session.selectOne("restaurantMapper.selectRestaurantByOwnerId",ownerId);
	}
	@Override
	public List<Restaurant> selectRestaurantsByName(String restaurantName)
	{
		return session.selectList("restaurantMapper.selectRestaurantsByName",restaurantName);
	}

	@Override
	public List<Restaurant> selectRestaurantsByCustomerId(String ownerId)
	{
		
		return session.selectList("restaurantMapper.selectbycustomerId",ownerId);
	}
	
	public List<Restaurant> selectRestaurantPaging(int pageNo, String ownerId){
		
		HashMap parameter = new HashMap();
		parameter.put("contentPerPage", PagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		parameter.put("ownerId", ownerId);
		
		return session.selectList("restaurantMapper.selectRestaurantPaging", parameter);
	
		
	}
	@Override
	public int restaurantCountByrestaurantId(String ownerId) {
		// TODO Auto-generated method stub
		return session.selectOne("restaurantMapper.restaurantCountByrestaurantId", ownerId);
	}
	
	
	
}
