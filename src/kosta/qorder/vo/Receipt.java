package kosta.qorder.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kosta.qorder.util.JsonDateSerializer;

public class Receipt implements Serializable {

	private int receiptId;		//PK
	private Date receiptDate;
	private int receiptTable;
	private String receiptState;
	private String customerId;
	private int restaurantId;
	private Restaurant restaurant;
	private List<OrderList> orderList;
	public Receipt() {}
	
	public Receipt(Date receiptDate, int receiptTable, String receiptState, String customerId,
			int restaurantId)
	{
		super();
		this.receiptDate = receiptDate;
		this.receiptTable = receiptTable;
		this.receiptState = receiptState;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
	}
	
	public Receipt(int receiptId, Date receiptDate, int receiptTable, String receiptState, String customerId,
			int restaurantId)
	{
		super();
		this.receiptId = receiptId;
		this.receiptDate = receiptDate;
		this.receiptTable = receiptTable;
		this.receiptState = receiptState;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
	}
	public Receipt(int receiptId, Date receiptDate, int receiptTable, String receiptState, String customerId,
			int restaurantId, Restaurant restaurant)
	{
		super();
		this.receiptId = receiptId;
		this.receiptDate = receiptDate;
		this.receiptTable = receiptTable;
		this.receiptState = receiptState;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.restaurant = restaurant;
	}
	public Receipt(int receiptId, Date receiptDate, int receiptTable, String receiptState, String customerId,
			int restaurantId, List<OrderList> orderList)
	{
		super();
		this.receiptId = receiptId;
		this.receiptDate = receiptDate;
		this.receiptTable = receiptTable;
		this.receiptState = receiptState;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.orderList = orderList;
	}
	public Receipt(int receiptId, Date receiptDate, int receiptTable, String receiptState, String customerId,
			int restaurantId, Restaurant restaurant, List<OrderList> orderList)
	{
		super();
		this.receiptId = receiptId;
		this.receiptDate = receiptDate;
		this.receiptTable = receiptTable;
		this.receiptState = receiptState;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.restaurant = restaurant;
		this.orderList = orderList;
	}
	public int getReceiptId()
	{
		return receiptId;
	}
	public void setReceiptId(int receiptId)
	{
		this.receiptId = receiptId;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getReceiptDate()
	{
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate)
	{
		this.receiptDate = receiptDate;
	}
	public int getReceiptTable()
	{
		return receiptTable;
	}
	public void setReceiptTable(int receiptTable)
	{
		this.receiptTable = receiptTable;
	}
	public String getReceiptState()
	{
		return receiptState;
	}
	public void setReceiptState(String receiptState)
	{
		this.receiptState = receiptState;
	}
	public String getCustomerId()
	{
		return customerId;
	}
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	public int getRestaurantId()
	{
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId)
	{
		this.restaurantId = restaurantId;
	}
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	public List<OrderList> getOrderList()
	{
		return orderList;
	}
	public void setOrderList(List<OrderList> orderList)
	{
		this.orderList = orderList;
	}

	@Override
	public String toString()
	{
		return "Receipt [receiptId=" + receiptId + ", receiptDate=" + receiptDate + ", receiptTable=" + receiptTable
				+ ", receiptState=" + receiptState + ", customerId=" + customerId + ", restaurantId=" + restaurantId
				+ ", restaurant=" + restaurant + ", orderList=" + orderList + "]";
	}
	
	
}
