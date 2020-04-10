package kosta.qorder.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kosta.qorder.util.JsonDateSerializer;

public class Review implements Serializable {
	private int reviewId;
	private String reviewDescription;
	private Date reviewCreateDate;
	private String reviewType;
	private int itemId;
	private String customerId;
	private Customer customer;
	private Item item;
	public Review(){}
	
	public Review(int reviewId, String reviewDescription, Date reviewCreateDate, String reviewType, int itemId)
	{
		super();
		this.reviewId = reviewId;
		this.reviewDescription = reviewDescription;
		this.reviewCreateDate = reviewCreateDate;
		this.reviewType = reviewType;
		this.itemId = itemId;
	}
	
	
	public Review(String reviewDescription, Date reviewCreateDate, String reviewType, int itemId, String customerId,
			Item item)
	{
		super();
		this.reviewDescription = reviewDescription;
		this.reviewCreateDate = reviewCreateDate;
		this.reviewType = reviewType;
		this.itemId = itemId;
		this.customerId = customerId;
		this.item = item;
	}

	public Review(int reviewId, String reviewDescription, Date reviewCreateDate, String reviewType, int itemId,
			String customerId, Item item)
	{
		super();
		this.reviewId = reviewId;
		this.reviewDescription = reviewDescription;
		this.reviewCreateDate = reviewCreateDate;
		this.reviewType = reviewType;
		this.itemId = itemId;
		this.customerId = customerId;
		this.item = item;
	}

	public Review(String reviewDescription, String reviewType, int itemId, String customerId)
	{
		super();
		this.reviewDescription = reviewDescription;
		this.reviewType = reviewType;
		this.itemId = itemId;
		this.customerId = customerId;
	}

	public Review(int reviewId, String reviewDescription, Date reviewCreateDate, String reviewType, int itemId,
			String customerId)
	{
		super();
		this.reviewId = reviewId;
		this.reviewDescription = reviewDescription;
		this.reviewCreateDate = reviewCreateDate;
		this.reviewType = reviewType;
		this.itemId = itemId;
		this.customerId = customerId;
	}

	public Review(int reviewId, String reviewDescription, Date reviewCreateDate, String reviewType, int itemId,
			String customerId, Customer customer)
	{
		super();
		this.reviewId = reviewId;
		this.reviewDescription = reviewDescription;
		this.reviewCreateDate = reviewCreateDate;
		this.reviewType = reviewType;
		this.itemId = itemId;
		this.customerId = customerId;
		this.customer = customer;
	}

	public Review(String reviewDescription, Date reviewCreateDate, String reviewType, String customerId, int itemId)
	{
		this.reviewDescription = reviewDescription;
		this.reviewCreateDate=reviewCreateDate;
		this.reviewType=reviewType;
		this.customerId=customerId;
		this.itemId=itemId;
	}

	public int getReviewId()
	{
		return reviewId;
	}
	public void setReviewId(int reviewId)
	{
		this.reviewId = reviewId;
	}
	public String getReviewDescription()
	{
		return reviewDescription;
	}
	public void setReviewDescription(String reviewDescription)
	{
		this.reviewDescription = reviewDescription;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getReviewCreateDate()
	{
		return reviewCreateDate;
	}
	public void setReviewCreateDate(Date reviewCreateDate)
	{
		this.reviewCreateDate = reviewCreateDate;
	}
	public String getReviewType()
	{
		return reviewType;
	}
	public void setReviewType(String reviewType)
	{
		this.reviewType = reviewType;
	}
	public int getItemId()
	{
		return itemId;
	}
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public String getCustomerId()
	{
		return customerId;
	}
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
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
		return "Review [reviewId=" + reviewId + ", reviewDescription=" + reviewDescription + ", reviewCreateDate="
				+ reviewCreateDate + ", reviewType=" + reviewType + ", itemId=" + itemId + ", customerId=" + customerId
				+ ", customer=" + customer + ", item=" + item + "]";
	}
	
}
