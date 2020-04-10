package kosta.qorder.service;

import java.util.List;

import kosta.qorder.vo.Customer;

public interface CustomerService
{
	void addCustomer(Customer customer);
	void removeCustomer(String customerId);
	void updateCustomer(Customer customer);
	Customer findCustomerById(String customerId);
	List<Customer> getCustomersByName(String customerName);
	List<Customer> getAllCustomers();
}
