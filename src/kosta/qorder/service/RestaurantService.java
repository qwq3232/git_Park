package kosta.qorder.service;

import java.util.List;
import java.util.Map;

import kosta.qorder.vo.Restaurant;

public interface RestaurantService
{
	void addRestaurant(Restaurant restaurant);
	void removeRestaurantById(int restaurantId);
	void updateRestaurantById(Restaurant restaurant);
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restaurantId);
	Restaurant getRestaurantByOwnerId(String ownerId);
	List<Restaurant> getAllRestaurantsByName(String restaurantName);
	List<Restaurant>selectRestaurantsByCustomerId(String ownerId);
	Map getRestaurantsByPaging(int pageNo, String ownerId);
	int getRestaurantsByownerId(String ownerId);
	
}
