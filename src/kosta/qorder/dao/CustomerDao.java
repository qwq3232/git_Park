package kosta.qorder.dao;

import java.util.List;

import kosta.qorder.vo.Customer;

public interface CustomerDao
{
	int insertCustomer(Customer customer);
	int deleteCustomerById(String customerId);
	int updateCustomerById(Customer customer);
	List<Customer> selectCustomers();
	Customer selectCustomerById(String customerId);
	List<Customer> selectCustomersByName(String customerName);
}
