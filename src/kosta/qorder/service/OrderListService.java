package kosta.qorder.service;

import java.util.List;

import kosta.qorder.vo.OrderList;


public interface OrderListService
{
	void addOrderList(OrderList orderList);
	void removeOrderList(int orderListId);
	void updateOrderListById(OrderList orderList);
	OrderList findOrderListById(int orderListId);
	List<OrderList> getAllOrderLists();
	List<OrderList> getOrderListsByReceiptId(int receiptId);
}
