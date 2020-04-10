package kosta.qorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.qorder.dao.CustomerDao;
import kosta.qorder.vo.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService
{
	private CustomerDao dao;
	public CustomerServiceImpl(){}
	
	@Autowired
	private CustomerServiceImpl(CustomerDao dao)
	{
		this.dao = dao;
	}

	@Override
	public void addCustomer(Customer customer)
	{
		dao.insertCustomer(customer);
		
	}

	@Override
	public void removeCustomer(String customerId)
	{
		dao.deleteCustomerById(customerId);
	}

	@Override
	public void updateCustomer(Customer customer)
	{
		dao.updateCustomerById(customer);
	}

	@Override
	public Customer findCustomerById(String customerId)
	{
		return dao.selectCustomerById(customerId);
	}

	@Override
	public List<Customer> getCustomersByName(String customerName)
	{
		return dao.selectCustomersByName(customerName);
	}

	@Override
	public List<Customer> getAllCustomers()
	{
		return dao.selectCustomers();
	}
	
}
