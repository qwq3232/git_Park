package kosta.qorder.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.qorder.service.ItemService;
import kosta.qorder.service.OrderListService;
import kosta.qorder.service.ReceiptService;
import kosta.qorder.service.RestaurantService;
import kosta.qorder.service.ReviewService;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.OrderList;
import kosta.qorder.vo.QrInfo;
import kosta.qorder.vo.Receipt;
import kosta.qorder.vo.Restaurant;
import kosta.qorder.vo.Review;

@Controller
@RequestMapping("/login/")
public class EventController
{
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	ItemService itemService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	OrderListService orderListService;
	@Autowired
	ReceiptService receiptService;
	
	private static Logger logger = Logger.getLogger(EventController.class);
	
	@RequestMapping("event.do")
	public ModelAndView RestaurantList(HttpSession session)
	{
		logger.debug("log");
		session.setAttribute("table", 0);
		List<Restaurant> list=restaurantService.getAllRestaurants();
		return new ModelAndView("event.tiles","list",list);
	}
	@RequestMapping("reviewList.do")
	@ResponseBody
	public List<Review> ReviewList(@RequestParam int itemId)
	{
		logger.debug("리뷰리스트");
		List<Review> list = reviewService.getReviewByItemId(itemId);
		for(int index=0; index<list.size(); index++)
		{
			Item item = itemService.getItemById(list.get(index).getItemId());
			list.get(index).setItem(item);
		}
		return list;
	}
	@RequestMapping("insertReview.do")
	public String insertReview(@ModelAttribute Review review, @RequestParam String ratingValue)
	{
		int ratingInteger = 0 ;
		if(ratingValue.equals("★"))
			ratingInteger = 1;
		else if(ratingValue.equals("★★"))
			ratingInteger = 2;
		else if(ratingValue.equals("★★★"))
			ratingInteger = 3;
		else if(ratingValue.equals("★★★★"))
			ratingInteger = 4;
		else if(ratingValue.equals("★★★★★"))
			ratingInteger = 5;
		review.setReviewCreateDate(new Date());
		logger.debug(review.toString()+" - "+ratingValue);
		Item item = itemService.getItemById(review.getItemId());
		item.setItemRating(item.getItemRating()+ratingInteger);
		item.setItemRatingCount(item.getItemRatingCount()+1);
		return null;
	}

	@RequestMapping("itemList.do")
	public ModelAndView ItemList(@RequestParam int restaurantId, HttpSession session)
	{
		logger.debug("log");
		session.setAttribute("table", 0);
		session.setAttribute("restaunantId", restaurantId);
		List<Item> list = itemService.getItemByRestaurantId(restaurantId);
		return new ModelAndView("itemlist.tiles","list",list);
	}
	
	@RequestMapping("itemListQr.do")
	public ModelAndView ItemListQr(@ModelAttribute QrInfo qrInfo, HttpSession session){
		logger.debug("log");
		session.setAttribute("restaunantId", qrInfo.getRestaurantId()); //session에 restaurant id 저장
		session.setAttribute("table", qrInfo.getReceiptTable()); //session에 table number 저장
		List<Item> list = itemService.getItemByRestaurantId(qrInfo.getRestaurantId());
		
		return new ModelAndView("itemlist.tiles","list",list);
	}
	
	@RequestMapping("itemBucketList.do")
	public ModelAndView ItemBucketList(@RequestParam int[] check_item, @RequestParam int[] count, @RequestParam int table, HttpSession session){
		
		logger.debug("Item bucketList 들어왔음");
		
		//select 값 중 초기값 0을 제외한 나머지 select 값만 받기
		int[] selectCount = new int[check_item.length];
		int j = 0;
		
		for(int i =0; i<count.length;i++)
		{
			if(count[i] != 0)
			{		
				selectCount[j++] = count[i];
			}
		}
		
		//테이블 번호 session에 저장
		if(table!=0)
			session.setAttribute("table", table);
		
		//session에 저장한 id와 restaurantId 값 불러오기
		String customerId = (String)session.getAttribute("customerId");
		int restaurantId = (int)session.getAttribute("restaunantId");
		
		//날짜 생성
		Date date = new Date();
		Receipt receipt = new Receipt(date, table, "wait", customerId, restaurantId);
		logger.debug(receipt+" 등록합니다");
		//주문서 등록
		receiptService.addReceipt(receipt);
		List<Receipt> findReceipt = receiptService.getReceiptByCustomerId(customerId);
		int receiptId = findReceipt.get(findReceipt.size()-1).getReceiptId();
		//장바구니 List 생성
		List<OrderList> list = new ArrayList<OrderList>();
		//주문목록 등록
		for(int i=0; i < check_item.length; i++)
		{
			//고객에 메뉴 가격 조회				
			Item item = itemService.getItemById(check_item[i]);
			logger.debug(item);
			//주문리스트 생성
			OrderList orderList = new OrderList(selectCount[i], item.getItemPrice(), check_item[i], receiptId);
			logger.debug(orderList);
			orderListService.addOrderList(orderList);
			orderList.setItem(item);
			list.add(orderList);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("itemFinallist.tiles");
		mv.addObject("receiptId",receiptId);
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("item_insert.do")
	public ModelAndView Item_Insert(@RequestParam int receiptId){
		
		List<OrderList> list = orderListService.getOrderListsByReceiptId(receiptId);
		for(int index = 0; index < list.size(); index++)
		{
			Item item = itemService.getItemById(list.get(index).getItemId());
			list.get(index).setItem(item);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("payment.tiles");
		mv.addObject("list",list);
		return mv;
	
	}
}
