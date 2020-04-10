package kosta.qorder.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kosta.qorder.service.CustomerService;
import kosta.qorder.service.CustomerServiceImpl;
import kosta.qorder.service.RestaurantService;
import kosta.qorder.vo.Customer;

@Component
public class CustomerValidator implements Validator
{
	@Autowired
	private CustomerService service;
	@Override
	public boolean supports(Class<?> clazz)
	{
		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors error)
	{
		Customer customer = (Customer) target;
		Customer findCustomer = service.findCustomerById(customer.getCustomerId());
		if(!supports(target.getClass()))
		{
			error.reject("검증할수 없는 객체입니다.");
			return;
		}
		if(customer.getCustomerId()==null||customer.getCustomerId().trim().isEmpty())
		{
			error.rejectValue("customerId", "idRequired");
		}
		else if(findCustomer!=null)
		{
			error.rejectValue("customerId", "duplicate");
		}
		if(customer.getCustomerPassword()==null||customer.getCustomerPassword().trim().isEmpty())
		{
			error.rejectValue("customerPassword", "passwordRequired");
		}
		if(customer.getCustomerName()==null || customer.getCustomerName().trim().isEmpty())
		{
			error.rejectValue("customerName", "required");
		}
	}

}
