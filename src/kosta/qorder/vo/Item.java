package kosta.qorder.vo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

	private int itemId;
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	private String itemSort;
	private String itemImage;
	private double itemRating;
	private int itemRatingCount;
	private int restaurantId;
	private List<Review> review;
	public Item() {
		super();
	}
	public Item(int itemId, String itemName, String itemDescription, int itemPrice, String itemSort, String itemImage,
			double itemRating, int itemRatingCount, int restaurantId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemSort = itemSort;
		this.itemImage = itemImage;
		this.itemRating = itemRating;
		this.itemRatingCount = itemRatingCount;
		this.restaurantId = restaurantId;
	}
	
	public Item(int itemId, String itemName, String itemDescription, int itemPrice, String itemSort, String itemImage,
			double itemRating, int itemRatingCount, int restaurantId, List<Review> review)
	{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemSort = itemSort;
		this.itemImage = itemImage;
		this.itemRating = itemRating;
		this.itemRatingCount = itemRatingCount;
		this.restaurantId = restaurantId;
		this.review = review;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemSort() {
		return itemSort;
	}
	public void setItemSort(String itemSort) {
		this.itemSort = itemSort;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public double getItemRating() {
		return itemRating;
	}
	public void setItemRating(double itemRating) {
		this.itemRating = itemRating;
	}
	public int getItemRatingCount() {
		return itemRatingCount;
	}
	public void setItemRatingCount(int itemRatingCount) {
		this.itemRatingCount = itemRatingCount;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
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
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemPrice=" + itemPrice + ", itemSort=" + itemSort + ", itemImage=" + itemImage + ", itemRating="
				+ itemRating + ", itemRatingCount=" + itemRatingCount + ", restaurantId=" + restaurantId + ", review="
				+ review + "]";
	}
	
}