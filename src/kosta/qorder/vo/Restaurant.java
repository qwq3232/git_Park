package kosta.qorder.vo;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable {

	// 기본 생성자
	private int restaurantId;
	private String restaurantName;
	private String restaurantDescription;
	private String restaurantPhone;
	private String restaurantAddress;
	private double restaurantLatitude; // GPS 위도
	private double restaurantLongitude; // GPS 경도
	private String restaurantImage;
	private double restaurantRating;
	private int restaurantRatingCount;
	private int restaurantMileagePercent;
	private String ownerId;
	// 추가 생성자
	private List<Item> itemList;
	private Customer owner;
	public Restaurant() {
		super();
	}
	
	public Restaurant(int restaurantId, String restaurantName, String restaurantDescription, String restaurantPhone,
			String restaurantAddress, double restaurantLatitude, double restaurantLongitude, String restaurantImage,
			double restaurantRating, int restaurantRatingCount, int restaurantMileagePercent, String ownerId)
	{
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantDescription = restaurantDescription;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddress = restaurantAddress;
		this.restaurantLatitude = restaurantLatitude;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantImage = restaurantImage;
		this.restaurantRating = restaurantRating;
		this.restaurantRatingCount = restaurantRatingCount;
		this.restaurantMileagePercent = restaurantMileagePercent;
		this.ownerId = ownerId;
	}
	
	public Restaurant(int restaurantId, String restaurantName, String restaurantDescription, String restaurantPhone,
			String restaurantAddress, double restaurantLatitude, double restaurantLongitude, String restaurantImage,
			double restaurantRating, int restaurantRatingCount, int restaurantMileagePercent, String ownerId,
			List<Item> itemList)
	{
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantDescription = restaurantDescription;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddress = restaurantAddress;
		this.restaurantLatitude = restaurantLatitude;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantImage = restaurantImage;
		this.restaurantRating = restaurantRating;
		this.restaurantRatingCount = restaurantRatingCount;
		this.restaurantMileagePercent = restaurantMileagePercent;
		this.ownerId = ownerId;
		this.itemList = itemList;
	}

	public Restaurant(int restaurantId, String restaurantName, String restaurantDescription, String restaurantPhone,
			String restaurantAddress, double restaurantLatitude, double restaurantLongitude, String restaurantImage,
			double restaurantRating, int restaurantRatingCount, int restaurantMileagePercent, String ownerId,
			List<Item> itemList, Customer owner)
	{
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantDescription = restaurantDescription;
		this.restaurantPhone = restaurantPhone;
		this.restaurantAddress = restaurantAddress;
		this.restaurantLatitude = restaurantLatitude;
		this.restaurantLongitude = restaurantLongitude;
		this.restaurantImage = restaurantImage;
		this.restaurantRating = restaurantRating;
		this.restaurantRatingCount = restaurantRatingCount;
		this.restaurantMileagePercent = restaurantMileagePercent;
		this.ownerId = ownerId;
		this.itemList = itemList;
		this.owner = owner;
	}

	public int getRestaurantId()
	{
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId)
	{
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName()
	{
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName)
	{
		this.restaurantName = restaurantName;
	}

	public String getRestaurantDescription()
	{
		return restaurantDescription;
	}

	public void setRestaurantDescription(String restaurantDescription)
	{
		this.restaurantDescription = restaurantDescription;
	}

	public String getRestaurantPhone()
	{
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone)
	{
		this.restaurantPhone = restaurantPhone;
	}

	public String getRestaurantAddress()
	{
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress)
	{
		this.restaurantAddress = restaurantAddress;
	}

	public double getRestaurantLatitude()
	{
		return restaurantLatitude;
	}

	public void setRestaurantLatitude(double restaurantLatitude)
	{
		this.restaurantLatitude = restaurantLatitude;
	}

	public double getRestaurantLongitude()
	{
		return restaurantLongitude;
	}

	public void setRestaurantLongitude(double restaurantLongitude)
	{
		this.restaurantLongitude = restaurantLongitude;
	}

	public String getRestaurantImage()
	{
		return restaurantImage;
	}

	public void setRestaurantImage(String restaurantImage)
	{
		this.restaurantImage = restaurantImage;
	}

	public double getRestaurantRating()
	{
		return restaurantRating;
	}

	public void setRestaurantRating(double restaurantRating)
	{
		this.restaurantRating = restaurantRating;
	}

	public int getRestaurantRatingCount()
	{
		return restaurantRatingCount;
	}

	public void setRestaurantRatingCount(int restaurantRatingCount)
	{
		this.restaurantRatingCount = restaurantRatingCount;
	}

	public int getRestaurantMileagePercent()
	{
		return restaurantMileagePercent;
	}

	public void setRestaurantMileagePercent(int restaurantMileagePercent)
	{
		this.restaurantMileagePercent = restaurantMileagePercent;
	}

	public String getOwnerId()
	{
		return ownerId;
	}

	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}

	public List<Item> getItemList()
	{
		return itemList;
	}

	public void setItemList(List<Item> itemList)
	{
		this.itemList = itemList;
	}

	public Customer getOwner()
	{
		return owner;
	}

	public void setOwner(Customer owner)
	{
		this.owner = owner;
	}
	
}