package kosta.qorder.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import kosta.qorder.validator.CustomerValidator;
import kosta.qorder.validator.ItemValidator;
import kosta.qorder.validator.RestaurantValidator;
import kosta.qorder.vo.Customer;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.OrderList;
import kosta.qorder.vo.QrInfo;
import kosta.qorder.vo.Receipt;
import kosta.qorder.vo.Restaurant;
import kosta.qorder.vo.Review;

@Controller
@RequestMapping("/login/admin/")
public class AdminController
{
	@Autowired
	private CustomerValidator customerValidator;
	@Autowired
	private ItemValidator itemValidator;
	@Autowired
	private RestaurantValidator restaurantValidator;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private OrderListService orderListService;
	@Autowired
	private ReviewService reviewService;
	private static Logger logger = Logger.getLogger(AdminController.class);

	
	
	/*
	 * INSERT
	 */
	
	@RequestMapping(value = "insertCustomer.do", method = RequestMethod.GET)
	public String insertCustomer()
	{
		logger.debug("log");
		return "admin/database/insert/customer.tiles";
	}

	@RequestMapping(value = "insertCustomer.do", method = RequestMethod.POST)
	public String insertCustomer(@ModelAttribute Customer customer, Errors errors, @RequestParam MultipartFile profile,
			HttpServletRequest request) throws IllegalStateException, IOException
	{

		logger.debug("log");
		customerValidator.validate(customer, errors);

		if (errors.hasErrors())
		{
			logger.debug("등록실패");

			return "admin/database/insert/customer.tiles";
		} else
		{
			logger.debug("customer DB에 등록");
			if (profile != null || profile.isEmpty())
			{
				String fileName = customer.getCustomerId() + ".png";
				String dir = request.getServletContext().getRealPath("/image/user/profile");
				logger.debug(fileName + " :: " + dir + "::");
				File file = new File(dir, fileName);
				profile.transferTo(file);
				String image = "/Qorder/image/user/profile/" + fileName;
				logger.debug("파일 경로 : " + image);
				customer.setCustomerImage(image);
			}
			customerService.addCustomer(customer);
			return "admin/database/insert/suceed.tiles";
		}
	}

	@RequestMapping(value = "insertItem.do", method = RequestMethod.GET)
	public String insertItem()
	{
		logger.debug("log");
		return "admin/database/insert/item.tiles";
	}

	@RequestMapping(value = "insertItem1.do", method = RequestMethod.POST)
	public ModelAndView insertItem(@ModelAttribute Item item, Errors errors, @RequestParam MultipartFile profile,
			HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException
	{
		logger.debug("insert item - method : POST");
		logger.debug("아이템 : " + item);
		int restaurantId = (Integer) session.getAttribute("restaurantId");
		ModelAndView mv = new ModelAndView();
		itemValidator.validate(item, errors);
		if (errors.hasErrors())
		{
			mv.setViewName("admin/database/insert/item.tiles");
			return mv;
		} else
		{
			if (profile != null || profile.isEmpty())
			{
				String fileName = item.getRestaurantId() + item.getItemName() + ".png";
				String dir = request.getServletContext().getRealPath("/image/user/restaurant/menu");
				logger.debug(fileName + " :: " + dir + "::");
				File file = new File(dir, fileName);
				profile.transferTo(file);
				String image = "/Qorder/image/user/restaurant/menu/" + fileName;
				item.setItemImage(image);
				logger.debug("파일 경로 : " + image);
			}

			item.setRestaurantId(restaurantId);
			itemService.addItem(item);
			mv.setViewName("admin/database/insert/suceed.tiles");
			return mv;
		}
	}

	@RequestMapping(value = "insertRestaurant.do", method = RequestMethod.GET)
	public String insertRestaurant()
	{
		logger.debug("log");
		return "admin/database/insert/restaurant.tiles";
	}

	@RequestMapping(value = "insertRestaurant.do", method = RequestMethod.POST)
	public String insertRestaurant(@ModelAttribute Restaurant restaurant, Errors errors,
			@RequestParam MultipartFile profile, HttpServletRequest request) throws IllegalStateException, IOException
	{
		logger.debug("log");
		restaurantValidator.validate(restaurant, errors);
		if (errors.hasErrors())
		{
			logger.debug("등록실패");
			return "admin/database/insert/restaurant.tiles";
		} else
		{
			logger.debug("customer DB에 등록");

			if (profile != null || profile.isEmpty())
			{
				String fileName = restaurant.getRestaurantId() + ".png";
				String dir = request.getServletContext().getRealPath("/image/user/profile");
				logger.debug(fileName + " :: " + dir + "::");
				File file = new File(dir, fileName);
				profile.transferTo(file);
				String image = "/Qorder/image/user/profile/" + fileName;
				logger.debug("파일 경로 : " + image);
				restaurant.setRestaurantImage(image);

			}

			restaurantService.addRestaurant(restaurant);
			return "admin/database/insert/suceed.tiles";
		}

	}

	
	/*
	 * SELECT
	 */
	
	@RequestMapping(value = "selectRestaurant.do", method = RequestMethod.GET)
	public ModelAndView selectRestaurant(HttpSession session, @RequestParam int pageNo)
	{
		logger.debug("selectRestaurant");
		if(pageNo == 0){		
			pageNo = 1;
		}
		String ownerId = (String)session.getAttribute("customerId");
		Map map = restaurantService.getRestaurantsByPaging(pageNo, ownerId);
		return new ModelAndView("admin/database/select/restaurant.tiles","list", map);
	}

	@RequestMapping(value = "selectCustomer.do", method = RequestMethod.GET)
	public ModelAndView selectCustomer()
	{
		logger.debug("selectCustomer");
		List<Customer> list = customerService.getAllCustomers();
		return new ModelAndView("admin/database/select/customer.tiles", "list", list);
	}

	@RequestMapping(value = "selectItem.do", method = RequestMethod.GET)
	public ModelAndView selectItem(HttpSession session, @RequestParam int pageNo)
	{
		logger.debug("selectItem");
		if(pageNo == 0){
			pageNo = 1;
		}
		int restaurantId = (Integer)session.getAttribute("restaurantId");
		Map map = itemService.getItemByPaging(pageNo, restaurantId);
		return new ModelAndView("admin/database/select/item.tiles","list",map);
	}
	
	@RequestMapping(value = "selectReceipt.do", method = RequestMethod.GET)
	public ModelAndView selectReceipt(HttpSession session, @RequestParam int pageNo)
	{
		logger.debug("selectReceipt");
		if(pageNo == 0){
			pageNo = 1;	
		}
		int restaurantId = (Integer)session.getAttribute("restaurantId");
		Map map = receiptService.getreceiptByPaging(pageNo, restaurantId);
		return new ModelAndView("admin/database/select/receipt.tiles","list", map);
	
	}

	@RequestMapping("selectOrderList")
	public ModelAndView selectOrderList(@RequestParam int receiptId)
	{
		List<OrderList> list = orderListService.getOrderListsByReceiptId(receiptId);
		for (int index = 0; index < list.size(); index++)
		{
			Item item = itemService.getItemById(list.get(index).getItemId());
			list.get(index).setItem(item);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/database/select/orderlist.tiles");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("selectReview")
	public ModelAndView selectReview()
	{
		ModelAndView mv = new ModelAndView();
		List<Review> list = reviewService.getAllReviews();
		mv.setViewName("admin/database/select/review.tiles");
		mv.addObject("list", list);
		return mv;
	}
	
	/*
	 * UPDATE
	 */
	@RequestMapping(value = "updateCustomer.do", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@RequestParam String customerId, @ModelAttribute Customer customer,
			HttpSession session)
	{

		Customer cus = customerService.findCustomerById(customerId);

		logger.debug("log");
		return new ModelAndView("admin/database/update/customer.tiles", "cus", cus);

	}

	@RequestMapping(value = "updateCustomer.do", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute Customer customer, @RequestParam MultipartFile profile,
			HttpSession session, HttpServletRequest request) throws IllegalStateException, IOException
	{

		logger.debug("log");
		customerService.updateCustomer(customer);
		return new ModelAndView("admin/database/update/suceed.tiles");
	}
	@RequestMapping(value = "updateRestaurant.do", method = RequestMethod.GET)
	public ModelAndView updateRestaurant(@RequestParam int restaurantId, @ModelAttribute Restaurant restaurant,
			HttpSession session)
	{

		restaurant = restaurantService.getRestaurantById(restaurantId);
		logger.debug(restaurant);
		return new ModelAndView("admin/database/update/restaurant.tiles", "res", restaurant);

	}

	@RequestMapping(value = "updateRestaurant.do", method = RequestMethod.POST)
	public ModelAndView updateRestaurant(@ModelAttribute Restaurant restaurant, @RequestParam MultipartFile profile,
			HttpSession session, HttpServletRequest request) throws IllegalStateException, IOException
	{

		logger.debug("log");

		if (profile != null || profile.isEmpty())
		{
			String fileName = restaurant.getRestaurantId() + ".png";
			String dir = request.getServletContext().getRealPath("/image/user/profile");
			logger.debug(fileName + " :: " + dir + "::");
			File file = new File(dir, fileName);
			profile.transferTo(file);
			String image = "/Qorder/image/user/profile/" + fileName;
			logger.debug("파일 경로 : " + image);
			restaurant.setRestaurantImage(image);
		}
		System.out.println(restaurant);
		restaurantService.updateRestaurantById(restaurant);

		return new ModelAndView("admin/database/update/suceed.tiles");
	}

	@RequestMapping(value = "updateItem.do", method = RequestMethod.GET)
	public ModelAndView updateItem(@RequestParam int itemId,
			HttpSession session)
	{
		Item item = itemService.getItemById(itemId);
		session.setAttribute("item", item);
		logger.debug("log");
		return new ModelAndView("admin/database/update/Item.tiles", "item",
				item);
	}

	@RequestMapping(value = "updateItem.do", method = RequestMethod.POST)
	public ModelAndView updateItem(@ModelAttribute Item item, Errors errors,
			@RequestParam MultipartFile profile, HttpServletRequest request,HttpSession session)
					throws IllegalStateException, IOException
	{
		
		
		if (profile != null || profile.isEmpty())
		{
			String fileName = item.getRestaurantId() + item.getItemName()
					+ ".png";
			String dir = request.getServletContext()
					.getRealPath("/image/user/restaurant/menu");
			logger.debug(fileName + " :: " + dir + "::");
			File file = new File(dir, fileName);
			profile.transferTo(file);
			String image = "/Qorder/image/user/restaurant/menu/" + fileName;
			item.setItemImage(image);
			logger.debug("파일 경로 : " + image);
			
		}
		
		System.out.println(item.toString());
		
		itemService.updateItemId(item);
		return new ModelAndView("admin/database/update/suceed.tiles");
		
	}

	/*
	 * DELETE
	 */
	
	@RequestMapping(value = "deleatRestaurant.do", method = RequestMethod.GET)
	public ModelAndView deleatRestaurant(@RequestParam int restaurantId, @ModelAttribute Restaurant restaurant,
			HttpSession session)
	{
		logger.debug("###########" + restaurantId);

		restaurantService.removeRestaurantById(restaurantId);
		logger.debug("log");
		return new ModelAndView("admin/database/update/delete.tiles");

	}

	@RequestMapping(value = "deletItem.do", method = RequestMethod.GET)
	public ModelAndView deletItem(@ModelAttribute Item item, HttpSession session)
			throws IllegalStateException, IOException
	{

		int restaurantId = (Integer) session.getAttribute("restaurantId");

		item.setRestaurantId(restaurantId);

		itemService.removeItemId(item.getItemId());
		return new ModelAndView("admin/database/update/delete.tiles");

	}

	@RequestMapping(value = "deletCustomer.do", method = RequestMethod.GET)
	public ModelAndView deletCustomer(@RequestParam String customerId, @ModelAttribute Customer customer,
			HttpSession session) throws IllegalStateException, IOException
	{
		customerService.removeCustomer(customerId);
		return new ModelAndView("admin/database/update/delete.tiles");
	}

	/*
	 * 기타
	 */
	
	@RequestMapping("getReceiptJson")
	@ResponseBody
	public List<Receipt> getReceipt(HttpSession session)
	{
		List<Receipt> receiptList = receiptService.getAllReceipts();
		List<Receipt> receiptResult = new ArrayList<Receipt>();
		int restaurantId = (Integer) session.getAttribute("restaurantId");
		for (Receipt receipt : receiptList)
		{
			// receipt 상태가 주문대기일 경우 에만 리스트에 등록
			if (receipt.getReceiptState().equals("wait") && receipt.getRestaurantId() == restaurantId)
			{
				List<OrderList> orderList = orderListService.getOrderListsByReceiptId(receipt.getReceiptId());
				for (int order = 0; order < orderList.size(); order++)
				{
					Item item = itemService.getItemById(orderList.get(order).getItemId());
					orderList.get(order).setItem(item);
				}
				receipt.setOrderList(orderList);
				receiptResult.add(receipt);
			}
		}
		return receiptResult;
	}

	@RequestMapping("orderList.do")
	public ModelAndView orderList(HttpSession session)
	{
		List<Receipt> receiptList = receiptService.getAllReceipts();
		List<Receipt> receiptResult = new ArrayList<Receipt>();
		int restaurantId = (Integer) session.getAttribute("restaurantId");
		for (Receipt receipt : receiptList)
		{
			// receipt 상태가 주문대기일 경우 에만 리스트에 등록
			if (receipt.getReceiptState().equals("wait") && receipt.getRestaurantId() == restaurantId)
			{
				List<OrderList> orderList = orderListService.getOrderListsByReceiptId(receipt.getReceiptId());
				logger.debug(orderList+ " : "+orderList.size());
				for (int order = 0; order < orderList.size(); order++)
				{
					Item item = itemService.getItemById(orderList.get(order).getItemId());
					logger.debug(item);
					orderList.get(order).setItem(item);
				}
				receipt.setOrderList(orderList);
				receiptResult.add(receipt);
			}
		}
		return new ModelAndView("admin/orderList.tiles", "list", receiptResult);
	}

	@RequestMapping("orderListCheck.do")
	@ResponseBody
	public String orderListCheck(@RequestParam int receiptId)
	{
		logger.debug("@@@@@@@@@@@@@orderList Check AJAX");
		Receipt receipt = receiptService.getReceiptById(receiptId);
		receipt.setReceiptState("commit");
		receiptService.updateReceipt(receipt);
		return "주문처리완료";
	}
	

	@RequestMapping(value = "restaurantId.do", method = RequestMethod.GET)
	public String restaurantId(@RequestParam int restaurantId, HttpSession session)
	{
		logger.debug("@@@@@@@@@@@@@" + restaurantId);

		session.setAttribute("restaurantId", restaurantId);
		return "admin/main.tiles";
	}
	@RequestMapping("logout")
	public String Logout(HttpSession session)
	{
		logger.debug("session에 있는 정보를 전부 날립니다");
		session.removeAttribute("customerId");
		session.removeAttribute("customerType");
		session.removeAttribute("restaurantId");
		return "/index/login.do";
	}
}
