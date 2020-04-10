package kosta.qorder.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.qorder.service.CustomerService;
import kosta.qorder.service.ItemService;
import kosta.qorder.service.ReceiptService;
import kosta.qorder.service.RestaurantService;
import kosta.qorder.service.ReviewService;
import kosta.qorder.vo.Customer;
import kosta.qorder.vo.Restaurant;

public class QorderTest
{
	public static void main(String[] args)
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("kosta/qorder/test/spring_config_test.xml");
		System.out.println("Customer TEST");
/*		CustomerService cs = (CustomerService)ctx.getBean("customerService");
		Customer cus = new Customer("test3", "test", "test", "test", 200, "test");
		cs.addCustomer(cus);*/
		
		/*	System.out.println("Item TEST");
		ItemService itemService = (ItemService)ctx.getBean("");
		
		System.out.println("Receipt TEST");
		ReceiptService receiptService = (ReceiptService)ctx.getBean("");
		System.out.println("Review TEST");
		ReviewService reviewService = (ReviewService)ctx.getBean("");*/
		
		System.out.println("Restaurant TEST");
		RestaurantService rs = (RestaurantService)ctx.getBean("restaurantService");
		Restaurant res = new Restaurant(1, "sampleName", "sampleDes", "010-1515-5612", "sampleAddre", 10.2153, 15.1515, "samplePath", 0.1, 0, 10, "test");
		rs.addRestaurant(res);
		System.out.println(rs.getAllRestaurants());
		
	}
}
