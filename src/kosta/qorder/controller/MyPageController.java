package kosta.qorder.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.qorder.service.CustomerService;
import kosta.qorder.service.ItemService;
import kosta.qorder.service.OrderListService;
import kosta.qorder.service.ReceiptService;
import kosta.qorder.service.RestaurantService;
import kosta.qorder.service.ReviewService;
import kosta.qorder.vo.Customer;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.OrderList;
import kosta.qorder.vo.Receipt;
import kosta.qorder.vo.Restaurant;
import kosta.qorder.vo.Review;

@Controller
@RequestMapping("/login/")
public class MyPageController {
   
   @Autowired
   private CustomerService customerService;
   @Autowired
   private ReceiptService receiptService;
   @Autowired
   private OrderListService orderListService;
   @Autowired
   private ReviewService reviewService;
   @Autowired
   private RestaurantService restaurantService;
   @Autowired
   private ItemService itemService;
   private static Logger logger = Logger.getLogger(MyPageController.class);
   
   @RequestMapping(value="mypage.do")
   public ModelAndView MyPage(HttpSession session)
   {
	  logger.debug("log");
      String customerId = (String)session.getAttribute("customerId");
      Customer customer = customerService.findCustomerById(customerId);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("mypage.tiles");
      mv.addObject("customer", customer);
      return mv;
   }

   @RequestMapping(value="update.do", method=RequestMethod.POST)
   public ModelAndView Update(@ModelAttribute Customer customer ,Errors errors, HttpSession session, @RequestParam MultipartFile profile, HttpServletRequest request) throws IllegalStateException, IOException
   {
	  logger.debug("log");
      ModelAndView mv = new ModelAndView();
      System.out.println(errors.getErrorCount());
      if(profile != null || profile.isEmpty())
      {
         String fileName = customer.getCustomerId() + ".png";
         String dir = request.getServletContext().getRealPath("/image/user/profile");
         logger.debug(fileName + " :: " + dir + "::");
         File file = new File(dir, fileName);
         profile.transferTo(file);
         String image = "/Qorder/image/user/profile/" + fileName ;
         logger.debug("파일 경로 : " + image);
         customer.setCustomerImage(image);
         
      }
      customerService.updateCustomer(customer);
      mv.addObject("customer", customerService.findCustomerById(customer.getCustomerId()));
      mv.setViewName("mypage.tiles");
      return mv;

   }
   @RequestMapping("/withdraw.do")
   public String withdraw(HttpSession session)
   {
	  logger.debug("log");
      String customerId = (String)session.getAttribute("customerId");  
      customerService.removeCustomer(customerId);
      return "/index.do";
   }
   
   @RequestMapping("getReceiptList")
   @ResponseBody
   public List<Receipt> getReceiptList(@RequestParam String customerId)
   {
	   logger.debug(customerId);
	   List<Receipt> receiptList = receiptService.getReceiptByCustomerId(customerId);
	   logger.debug(receiptList);
	   List<Receipt> resultList = new ArrayList<Receipt>();
	   for(Receipt receipt : receiptList)
	   {
		   if(receipt.getCustomerId().equals(customerId))
		   {
			   List<OrderList> orderList = orderListService.getOrderListsByReceiptId(receipt.getReceiptId());
			   for(int index = 0; index < orderList.size(); index++)
			   {
				   Item item = itemService.getItemById(orderList.get(index).getItemId());
				   orderList.get(index).setItem(item);
			   }
			   receipt.setOrderList(orderList);
			   Restaurant restaurant = restaurantService.getRestaurantById(receipt.getRestaurantId());
			   receipt.setRestaurant(restaurant);
			   resultList.add(receipt);
		   }
	   }
	   return resultList;
   }
   @RequestMapping("getReviewList")
   @ResponseBody
   public List<Review> getReviewList(@RequestParam String customerId)
   {
	   List<Review> list = reviewService.getReviewsByCustomerId(customerId);
	   for(int index = 0; index < list.size(); index++)
	   {
		   Item item = itemService.getItemById(list.get(index).getItemId());
		   list.get(index).setItem(item);
	   }
	   System.out.println("--------------------------"+list);
	   return list;
   }
}