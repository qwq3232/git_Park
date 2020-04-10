package kosta.qorder.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.qorder.service.ItemService;
import kosta.qorder.service.ReviewService;
import kosta.qorder.vo.Item;
import kosta.qorder.vo.Review;

@Controller
@RequestMapping("/review/")
public class ReviewController {

	private static Logger logger = Logger.getLogger(EventController.class);
	
	@Autowired
	ItemService itemService;
	@Autowired
	ReviewService reviewService;
	
	
	//댓글 등록 컨트롤러
	@RequestMapping("insertReview.do")
	@ResponseBody
	public Item insertReview(@RequestParam int itemId, @RequestParam String reviewText, @RequestParam int itemRate, HttpSession session)
	{
		
		Date date = new Date();
		String userId = (String)session.getAttribute("customerId");
		int restaurantId = (int)session.getAttribute("restaunantId");
		
		//리뷰 객체 생성
		Review review = new Review(reviewText, date, "메뉴" , userId, itemId);
		
		//리뷰 등록
		reviewService.addReview(review);
		
		//메뉴 평점 등록
		Item item = itemService.getItemById(itemId);
		
		//평점 등록
		item.setItemRating(itemRate);
		
		//평점 갱신
		itemService.updateItemId(item);
		
		//성공
		return item;
	
	}
	
	//해당 메뉴 댓글 출력하는 컨트롤러
	@RequestMapping("displayReview.do")
	public ModelAndView displayReview(@RequestParam int restaurantId, @RequestParam int pageNo)
	{
		
		ModelAndView mv = new ModelAndView();
		
		if(pageNo == 0){		
			pageNo = 1;
		}
		
		//현재 레스토랑에 등록된 아이템 목록
		Map map = reviewService.getReviewByPaging(pageNo, restaurantId);
	
		//성공
		mv.addObject("list", map);
		mv.addObject("restaurantId", restaurantId);
		mv.setViewName("restaurantReview.tiles");
		
		return mv;
	
	}
	
}
