package kosta.qorder.vo;

import java.io.Serializable;

public class OrderList implements Serializable
{
	private int orderListId;	//PK
	private int itemCount;
	private int itemPrice;
	private int itemId;			//FK
	private int receiptId;		//FK
	private Item item;
	public OrderList(){}
	public OrderList(int itemCount, int itemPrice, int itemId, int receiptId)
	{
		super();
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
		this.itemId = itemId;
		this.receiptId = receiptId;
	}
	
	public OrderList(int orderListId, int itemCount, int itemPrice, int itemId, int receiptId)
	{
		super();
		this.orderListId = orderListId;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
		this.itemId = itemId;
		this.receiptId = receiptId;
	}
	public OrderList(int itemCount, int itemPrice, int itemId, int receiptId, Item item)
	{
		super();
		this.itemId = itemId;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
		this.receiptId = receiptId;
		this.item = item;
	}
	public int getOrderListId()
	{
		return orderListId;
	}
	public void setOrderListId(int orderListId)
	{
		this.orderListId = orderListId;
	}
	public int getItemId()
	{
		return itemId;
	}
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getItemCount()
	{
		return itemCount;
	}
	public void setItemCount(int itemCount)
	{
		this.itemCount = itemCount;
	}
	public int getItemPrice()
	{
		return itemPrice;
	}
	public void setItemPrice(int itemPrice)
	{
		this.itemPrice = itemPrice;
	}
	public int getReceiptId()
	{
		return receiptId;
	}
	public void setReceiptId(int receiptId)
	{
		this.receiptId = receiptId;
	}
	public Item getItem()
	{
		return item;
	}
	public void setItem(Item item)
	{
		this.item = item;
	}
	@Override
	public String toString()
	{
		return "OrderList [orderListId=" + orderListId + ", itemCount=" + itemCount + ", itemPrice=" + itemPrice
				+ ", itemId=" + itemId + ", receiptId=" + receiptId + ", item=" + item + "]";
	}
	
}
