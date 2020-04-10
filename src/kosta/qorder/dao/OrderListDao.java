package kosta.qorder.dao;

import java.util.List;

import kosta.qorder.vo.OrderList;

public interface OrderListDao
{
	int insertOrderList(OrderList orderList);
	int deleteOrderListById(int orderListId);
	int updateOrderListById(OrderList orderList);
	List<OrderList> selectOrderLists();
	OrderList selectOrderListById(int orderListId);
	List<OrderList> selectOrderListbyReceiptId(int receiptId);
}
