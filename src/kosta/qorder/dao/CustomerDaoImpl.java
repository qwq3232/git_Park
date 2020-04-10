package kosta.qorder.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.qorder.vo.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao
{
	private SqlSessionTemplate session;
	public CustomerDaoImpl(){}
	@Autowired
	public CustomerDaoImpl(SqlSessionTemplate session)
	{
		this.session=session;
	}
	@Override
	public int insertCustomer(Customer customer)
	{
		return session.insert("customerMapper.insertCustomer", customer);
	}

	@Override
	public int deleteCustomerById(String customerId)
	{
		return session.delete("customerMapper.deleteCustomerById",customerId);
	}

	@Override
	public int updateCustomerById(Customer customer)
	{
		return session.update("customerMapper.updateCustomerById",customer);
	}

	@Override
	public List<Customer> selectCustomers()
	{
		return session.selectList("customerMapper.selectCustomers");
	}
	@Override
	public Customer selectCustomerById(String customerId)
	{
		return session.selectOne("customerMapper.selectCustomerById", customerId);
	}
	@Override
	public List<Customer> selectCustomersByName(String customerName)
	{
		return session.selectList("customerMapper.selectCustomersByName",customerName);
	}

}
