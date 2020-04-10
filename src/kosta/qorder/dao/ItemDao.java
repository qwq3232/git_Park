package kosta.qorder.dao;

import java.util.List;

import kosta.qorder.vo.Item;

public interface ItemDao
{
	int insertItem(Item item);
	int deleteItemById(int itemId);
	int updateItemById(Item item);
	List<Item> selectItems();
	Item selectItemById(int itemId);
	List<Item> selectItemByRestaurantId(int restaurantId);
	List<Item> selectItemsByName(String itemName);
	List<Item> selectItemPaging(int pageNo, int restaurantId);
	int itemCountByrestaurantId(int restaurantId);

}