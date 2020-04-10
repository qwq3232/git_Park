package kosta.qorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.qorder.dao.OrderListDao;
import kosta.qorder.vo.OrderList;

@Service("orderListService")
public class OrderListServiceImpl implements OrderListService {

	private OrderListDao dao;
	
	public OrderListServiceImpl(){}
	
	@Autowired
	public OrderListServiceImpl(OrderListDao dao)
	{
		this.dao=dao;
	}
	
	@Override
	public void addOrderList(OrderList orderList) {
		// TODO Auto-generated method stub
		
		dao.insertOrderList(orderList);
		
	}

	@Override
	public void removeOrderList(int orderListId) {
		// TODO Auto-generated method stub
		
		dao.deleteOrderListById(orderListId);
		
	}

	@Override
	public void updateOrderListById(OrderList orderList) {
		// TODO Auto-generated method stub
		
		dao.updateOrderListById(orderList);
		
	}

	@Override
	public OrderList findOrderListById(int orderListId) {
		// TODO Auto-generated method stub
		return dao.selectOrderListById(orderListId);
	
	}

	@Override
	public List<OrderList> getAllOrderLists() {
		// TODO Auto-generated method stub
		return dao.selectOrderLists();
	}
	
	public List<OrderList> getOrderListsByReceiptId(int receiptId)
	{
		return dao.selectOrderListbyReceiptId(receiptId);
	}
}
