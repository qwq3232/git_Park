package kosta.qorder.dao;

import java.util.List;

import kosta.qorder.vo.Item;
import kosta.qorder.vo.Receipt;

public interface ReceiptDao
{
	//주문 삽입 dao
	int insertReceipt(Receipt receipt);
	
	//주문 삭제 dao
	int deleteReceiptById(int receiptId);
	
	//주문 수정 dao
	int updateReceipt(Receipt receipt);
	
	//주문 전체 조회 dao
	List<Receipt> selectReceipts();
	
	//주문 주인 id로 식당 정보 조회 dao
	Receipt selectReceiptById(int receiptId);

	//고객 ID로 조회
	List<Receipt> selectReceiptByCustomerId(String customerId);

	List<Receipt> selectReceiptPaging(int pageNo, int restaurantId);
	
	int receiptCountByrestaurantId(int restaurantId);
	
}
