package kosta.qorder.vo;

import java.io.Serializable;

public class QrInfo implements Serializable
{
	private int restaurantId;
	private int table;
	public QrInfo(){}
	public QrInfo(int restaurantId, int table)
	{
		super();
		this.restaurantId = restaurantId;
		this.table = table;
	}
	public int getRestaurantId()
	{
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId)
	{
		this.restaurantId = restaurantId;
	}
	public int getReceiptTable()
	{
		return table;
	}
	public void setReceiptTable(int table)
	{
		this.table = table;
	}
}
