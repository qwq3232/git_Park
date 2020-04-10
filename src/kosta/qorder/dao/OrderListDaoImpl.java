package kosta.qorder.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import kosta.qorder.vo.OrderList;

@Repository("orderListDao")
public class OrderListDaoImpl implements OrderListDao {
	
	
	private SqlSessionTemplate session;
	public OrderListDaoImpl(){}
	@Autowired
	public OrderListDaoImpl(SqlSessionTemplate session)
	{	
		this.session = session;
	}
	
	@Override
	public int insertOrderList(OrderList orderList) {
	
		// TODO Auto-generated method stub
		return session.insert("orderListMapper.insertOrderList", orderList);
	
	}

	@Override
	public int deleteOrderListById(int orderListId) {
	
		// TODO Auto-generated method stub
		return session.delete("orderListMapper.deleteOrderList", orderListId);
	
	}

	@Override
	public int updateOrderListById(OrderList orderList) {
	
		// TODO Auto-generated method stub
		return session.update("orderListMapper.updateOrderList", orderList);
	
	}

	@Override
	public List<OrderList> selectOrderLists() {
		// TODO Auto-generated method stub
		return session.selectList("orderListMapper.selectOrderList");
	}
	@Override
	public OrderList selectOrderListById(int orderListId) {
		
		// TODO Auto-generated method stub
		return session.selectOne("orderListMapper.selectOrderListById", orderListId);
	
	}
	public List<OrderList> selectOrderListbyReceiptId(int receiptId)
	{
		return session.selectList("selectOrderListbyReceiptId",receiptId);
	}
}
