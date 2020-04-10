package kosta.qorder.service;

import java.util.List;
import java.util.Map;

import kosta.qorder.vo.Receipt;

public interface ReceiptService
{
	void addReceipt(Receipt receipt);
	void removeReceiptById(int receiptId);
	void updateReceipt(Receipt receipt);
	List<Receipt> getAllReceipts();
	Receipt getReceiptById(int receiptId);
	List<Receipt> getReceiptByCustomerId(String customerId);
	Map getreceiptByPaging(int pageNo, int restaurantId);
	int getreceiptByrestaurantId(int restaurantId);
	
	
}
