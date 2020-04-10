package kosta.qorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.qorder.dao.RestaurantDao;
import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Restaurant;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
	private RestaurantDao dao;
	public RestaurantServiceImpl(){}
	@Autowired
	public RestaurantServiceImpl(RestaurantDao dao)
	{
		this.dao = dao;
	}
	@Override
	public void addRestaurant(Restaurant restaurant)
	{
		dao.insertRestaurant(restaurant);
	}

	@Override
	public void removeRestaurantById(int restaurantId)
	{
		dao.deleteRestaurantById(restaurantId);
	}

	@Override
	public void updateRestaurantById(Restaurant restaurant)
	{
		dao.updateRestaurantById(restaurant);
	}
	
	@Override
	public List<Restaurant> getAllRestaurants()
	{
		return dao.selectRestaurants();
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId)
	{
		return dao.selectRestaurantById(restaurantId);
	}
	
	@Override
	public Restaurant getRestaurantByOwnerId(String ownerId)
	{
		return dao.selectRestaurantByOwnerId(ownerId);
	}
	
	@Override
	public List<Restaurant> getAllRestaurantsByName(String restaurantName)
	{
		return dao.selectRestaurantsByName(restaurantName);
	}
	public List<Restaurant> selectRestaurantsByCustomerId(String ownerId)
	{
		
		return dao.selectRestaurantsByCustomerId(ownerId);
	}
	
	@Override
	public Map getRestaurantsByPaging(int pageNo, String ownerId) {
		
		HashMap map = new HashMap();
		List<Restaurant> restaurant_list = dao.selectRestaurantPaging(pageNo, ownerId);
		map.put("list", restaurant_list);
		
		int restaurantCount = getRestaurantsByownerId(ownerId);
		PagingBean pagingBean = new PagingBean(restaurantCount, pageNo);
		map.put("paging", pagingBean);
		
		return map;
		
	}
	
	@Override
	public int getRestaurantsByownerId(String ownerId) {
		// TODO Auto-generated method stub
		return dao.restaurantCountByrestaurantId(ownerId);
	}
	

}
