package kosta.qorder.vo;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

	private String customerId;
	private String customerPassword;
	private String customerName;
	private String customerImage;
	private int customerMileage;
	private String customerType;
	private List<Review> review;
	
	public Customer() {
		super();
	}
	
	public Customer(String customerId, String customerPassword)
	{
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
	}

	public Customer(String customerId, String customerPassword, String customerName, String customerImage,
			int customerMileage, String customerType)
	{
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerImage = customerImage;
		this.customerMileage = customerMileage;
		this.customerType = customerType;
	}

	public Customer(String customerId, String customerPassword, String customerName, String customerImage,
			int customerMileage, String customerType, List<Review> review)
	{
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerImage = customerImage;
		this.customerMileage = customerMileage;
		this.customerType = customerType;
		this.review = review;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerPassword()
	{
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword)
	{
		this.customerPassword = customerPassword;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getCustomerImage()
	{
		return customerImage;
	}

	public void setCustomerImage(String customerImage)
	{
		this.customerImage = customerImage;
	}

	public int getCustomerMileage()
	{
		return customerMileage;
	}

	public void setCustomerMileage(int customerMileage)
	{
		this.customerMileage = customerMileage;
	}

	public String getCustomerType()
	{
		return customerType;
	}

	public void setCustomerType(String customerType)
	{
		this.customerType = customerType;
	}

	public List<Review> getReview()
	{
		return review;
	}

	public void setReview(List<Review> review)
	{
		this.review = review;
	}

	@Override
	public String toString()
	{
		return "Customer [customerId=" + customerId + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerImage=" + customerImage + ", customerMileage=" + customerMileage
				+ ", customerType=" + customerType + ", review=" + review + "]";
	}
	
	
}
