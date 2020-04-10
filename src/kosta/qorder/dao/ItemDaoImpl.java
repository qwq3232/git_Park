package kosta.qorder.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Item;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDao
{
	private SqlSessionTemplate session;
	public ItemDaoImpl(){}
	@Autowired
	public ItemDaoImpl(SqlSessionTemplate session)
	{	
		this.session = session;
	}
	
	@Override
	public int insertItem(Item item)
	{
		return session.insert("itemMapper.insertItem",item);
	}

	@Override
	public int deleteItemById(int itemId)
	{
		return session.delete("itemMapper.deleteItemById",itemId);
	}

	@Override
	public int updateItemById(Item item)
	{
		return session.update("itemMapper.updateItemById",item);
	}

	@Override
	public List<Item> selectItems()
	{
		return session.selectList("itemMapper.selectItems");
	}
	
	@Override
	public Item selectItemById(int itemId)
	{
		return session.selectOne("itemMapper.selectItemById",itemId);
	}
	@Override
	public List<Item> selectItemByRestaurantId(int restaurantId)
	{
		return session.selectList("itemMapper.selectItemByRestaurantId",restaurantId);
	}
	@Override
	public List<Item> selectItemsByName(String itemName)
	{
		return session.selectList("itemMapper.selectItemsByName",itemName);
	}
	@Override
	public List<Item> selectItemPaging(int pageNo, int restaurantId) {
		
		HashMap parameter = new HashMap();
		parameter.put("contentPerPage", PagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		parameter.put("restaurantId", restaurantId);
		
		return session.selectList("itemMapper.selectItemPaging", parameter);
	
	}
	@Override
	public int itemCountByrestaurantId(int restaurantId) {
	
		// TODO Auto-generated method stub
		return session.selectOne("itemMapper.itemCountByrestaurantId", restaurantId);
	
	}

}
