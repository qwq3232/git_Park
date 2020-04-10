package kosta.qorder.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.qorder.util.PagingBean;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.Receipt;

@Repository("receiptDao")
public class ReceiptDaoImpl	implements ReceiptDao
{
	private SqlSessionTemplate session;
	public ReceiptDaoImpl(){}
	@Autowired
	public ReceiptDaoImpl(SqlSessionTemplate session)
	{
		this.session=session;
	}
	@Override
	public int insertReceipt(Receipt receipt)
	{
		return session.insert("ReceiptMapper.insertReceipt",receipt);
	}

	@Override
	public int deleteReceiptById(int receiptId)
	{
		return session.delete("ReceiptMapper.deleteReceiptById",receiptId);
	}

	@Override
	public int updateReceipt(Receipt receipt)
	{
		return session.update("ReceiptMapper.updateReceiptById",receipt);
	}
	public List<Receipt> selectReceipts()
	{
		return session.selectList("ReceiptMapper.selectReceipt");
	}

	@Override
	public Receipt selectReceiptById(int receiptId)
	{
		return session.selectOne("ReceiptMapper.selectReceiptById",receiptId);
	}
	
	@Override
	public List<Receipt> selectReceiptByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return session.selectList("ReceiptMapper.selectReceiptByCustomerId", customerId);
	}
	@Override
	public List<Receipt> selectReceiptPaging(int pageNo, int restaurantId) {
		
		HashMap parameter = new HashMap();
		parameter.put("contentPerPage", PagingBean.CONTENT_PER_PAGE);
		parameter.put("pageNo", pageNo);
		parameter.put("restaurantId", restaurantId);
		
		return session.selectList("ReceiptMapper.selectReceiptPaging", parameter);
	}
	@Override
	public int receiptCountByrestaurantId(int restaurantId) {
		// TODO Auto-generated method stub
		return session.selectOne("ReceiptMapper.receiptCountByrestaurantId", restaurantId);
	}
	
	
	
}
