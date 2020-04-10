package kosta.qorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.qorder.dao.ItemDao;
import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.Restaurant;

@Service("itemService")
public class ItemServiceImpl implements ItemService
{
	private ItemDao dao;
	public ItemServiceImpl(){}
	@Autowired
	public ItemServiceImpl(ItemDao dao)
	{
		this.dao=dao;
	}
	@Override
	public void addItem(Item item)
	{
		dao.insertItem(item);
	}

	@Override
	public void removeItemId(int itemId)
	{
		dao.deleteItemById(itemId);
	}

	@Override
	public void updateItemId(Item item)
	{
		dao.updateItemById(item);
	}

	@Override
	public List<Item> getAllItems()
	{
		return dao.selectItems();
	}

	@Override
	public Item getItemById(int itemId)
	{
		return dao.selectItemById(itemId);
	}
	@Override
	public List<Item> getItemByRestaurantId(int restaurantId)
	{
		return dao.selectItemByRestaurantId(restaurantId);
	}
	@Override
	public List<Item> getItemsByName(String itemName)
	{
		return dao.selectItemsByName(itemName);
	}
	@Override
	public Map getItemByPaging(int pageNo, int restaurantId) {
		
		HashMap map = new HashMap();
		List<Item> item_list = dao.selectItemPaging(pageNo, restaurantId);
		map.put("list", item_list);
		
		int itemCount = getItemByrestaurantId(restaurantId);
		PagingBean pagingBean = new PagingBean(itemCount, pageNo);
		map.put("paging", pagingBean);
		
		return map;
		
	}
	@Override
	public int getItemByrestaurantId(int restaurantId) {
		
		// TODO Auto-generated method stub
		return dao.itemCountByrestaurantId(restaurantId);
	
	}

}
