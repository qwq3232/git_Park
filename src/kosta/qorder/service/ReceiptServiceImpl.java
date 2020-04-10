package kosta.qorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.qorder.dao.ReceiptDao;
import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.Receipt;

@Service("receiptService")
public class ReceiptServiceImpl implements ReceiptService
{
	private ReceiptDao dao;
	public ReceiptServiceImpl(){}
	@Autowired
	public ReceiptServiceImpl(ReceiptDao dao)
	{
		this.dao=dao;
	}
	@Override
	public void addReceipt(Receipt receipt)
	{
		dao.insertReceipt(receipt);
	}

	@Override
	public void removeReceiptById(int receiptId)
	{
		dao.deleteReceiptById(receiptId);
	}

	@Override
	public void updateReceipt(Receipt receipt)
	{
		dao.updateReceipt(receipt);
	}

	@Override
	public List<Receipt> getAllReceipts()
	{
		return dao.selectReceipts();
	}

	@Override
	public Receipt getReceiptById(int receiptId)
	{
		return dao.selectReceiptById(receiptId);
	}
	@Override
	public List<Receipt> getReceiptByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return dao.selectReceiptByCustomerId(customerId);
	}
	@Override
	public Map getreceiptByPaging(int pageNo, int restaurantId) {
		
		HashMap map = new HashMap();
		List<Receipt> receipt_list = dao.selectReceiptPaging(pageNo, restaurantId);
		map.put("list", receipt_list);
		
		int receiptCount = getreceiptByrestaurantId(restaurantId);
		PagingBean pagingBean = new PagingBean(receiptCount, pageNo);
		map.put("paging", pagingBean);
		
		return map;
	}
	@Override
	public int getreceiptByrestaurantId(int restaurantId) {
		// TODO Auto-generated method stub
		return dao.receiptCountByrestaurantId(restaurantId);
	}
	
	
	
}
