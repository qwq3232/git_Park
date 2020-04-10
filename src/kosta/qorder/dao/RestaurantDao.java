package kosta.qorder.dao;

import java.util.List;

import kosta.qorder.vo.Restaurant;

public interface RestaurantDao
{
	int insertRestaurant(Restaurant restaurant);
	int deleteRestaurantById(int restaurantId);
	int updateRestaurantById(Restaurant restaurant);
	List<Restaurant> selectRestaurants();
	Restaurant selectRestaurantById(int restaurantId);
	Restaurant selectRestaurantByOwnerId(String ownerId);
	List<Restaurant> selectRestaurantsByName(String restaurantName);
	List<Restaurant>selectRestaurantsByCustomerId(String ownerId);
	List<Restaurant> selectRestaurantPaging(int pageNo, String ownerId);
	int restaurantCountByrestaurantId(String ownerId);
	
}
