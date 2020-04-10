package kosta.qorder.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.qorder.service.RestaurantService;
import kosta.qorder.vo.Restaurant;

@Controller
@RequestMapping("/login/")
public class MapController
{
	@Autowired
	RestaurantService restaurantService;
	private static Logger logger = Logger.getLogger(MapController.class);
	
	@RequestMapping("maplist.do")
	@ResponseBody
	public List<Restaurant> RestaurantList()
	{
		List<Restaurant> list = restaurantService.getAllRestaurants();
		logger.debug("get restaurantList : "+list.size());
		return list;
	}
}
