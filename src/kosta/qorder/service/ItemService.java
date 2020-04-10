package kosta.qorder.service;

import java.util.List;
import java.util.Map;

import kosta.qorder.vo.Item;

public interface ItemService
{
	void addItem(Item item);
	void removeItemId(int itemId);
	void updateItemId(Item item);
	List<Item> getAllItems();
	Item getItemById(int itemId);
	List<Item> getItemByRestaurantId(int restaurantId);
	List<Item> getItemsByName(String itemName);
	Map getItemByPaging(int pageNo, int restaurantId);
	int getItemByrestaurantId(int restaurantId);

}
