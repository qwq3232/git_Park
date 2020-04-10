package kosta.qorder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.qorder.service.CustomerService;
import kosta.qorder.service.RestaurantService;
import kosta.qorder.validator.CustomerValidator;
import kosta.qorder.validator.LoginValidator;
import kosta.qorder.vo.Customer;
import kosta.qorder.vo.Restaurant;

@Controller
@RequestMapping("/index/")
public class IndexController
{
	@Autowired
	private CustomerValidator joinValidator;
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RestaurantService restaurantService;

	private static Logger logger = Logger.getLogger(IndexController.class);

	// login validator, index page
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login()
	{
		return "/WEB-INF/view/index.jsp";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Customer customer, Errors errors,HttpServletRequest request,HttpSession session)
	{
		session.removeAttribute("table");
		session.removeAttribute("restaurantId");
		session.removeAttribute("customerId");
		session.removeAttribute("customerType");
		ModelAndView mv= new ModelAndView();
		loginValidator.validate(customer, errors);
		logger.debug("login 입력 " + customer.getCustomerId() + " : "
				+ customer.getCustomerPassword());
		logger.debug("총 검증 실패 개수 : " + errors.getErrorCount());
		if (errors.hasErrors())
			return new ModelAndView("/WEB-INF/view/index.jsp");
		else
		{
			logger.debug("로그인성공 : Session" + customer.getCustomerId() + "-"
					+ customer.getCustomerPassword());
			session.setAttribute("customerId", customer.getCustomerId());
			Customer findCustomer = customerService
					.findCustomerById(customer.getCustomerId());
			logger.debug(findCustomer.getCustomerType());

			if (findCustomer.getCustomerType() != null)
			{
				if (findCustomer.getCustomerType().equals("owner"))
				{
					//사장일 경우
					session.setAttribute("customerId", customer.getCustomerId());
					List<Restaurant> list=restaurantService.selectRestaurantsByCustomerId(customer.getCustomerId());
					if(list.size()==1)
					{
						//식당 하나 가진 사장
						Restaurant restaurant = list.get(0);
						if(restaurant != null)
						{
							session.setAttribute("restaurantId", restaurant.getRestaurantId());
							return new ModelAndView("/login/admin/main.do");
						}
						else
							return new ModelAndView("/login/admin/main.do");
						//식당을 여러개 가진 사장
					}
					else
					{
						return new ModelAndView("admin/database/insert/item2.tiles","list",list);
					}	
				} 
				//관리자일 경우
				else if (findCustomer.getCustomerType().equals("admin"))
				{
					session.setAttribute("customerType", findCustomer.getCustomerType());
					List<Restaurant> list=restaurantService.selectRestaurantsByCustomerId(customer.getCustomerId());
					if(list.size()==1)
					{
						//식당 하나 가진 사장
						Restaurant restaurant = list.get(0);
						if(restaurant != null)
						{
							session.setAttribute("restaurantId", restaurant.getRestaurantId());
							return new ModelAndView("/login/admin/main.do");
						}
						else
							return new ModelAndView("/login/admin/main.do");
						//식당을 여러개 가진 사장
					}
					else
						return new ModelAndView("admin/database/insert/item2.tiles","list",list);
					
				} 
				//고객일 경우
				else
					return  new ModelAndView ("/login/camera.do");
			} 
			else
				return  new ModelAndView("/login/camera.do");
		}
	}
	   
	// join ajax controller
	@RequestMapping(value = "idCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam String customerId)
	{
		logger.debug("AJAX : " + customerId);
		if (customerService.findCustomerById(customerId) == null)
			return customerId;
		else
			return null;
	}

	// join validator
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public String join()
	{
		logger.debug("log");
		return "/WEB-INF/view/join.jsp";
	}

	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String join(@ModelAttribute Customer customer, Errors errors)
	{
		joinValidator.validate(customer, errors);
		logger.debug("join 입력 " + customer.getCustomerId() + " : "+ customer.getCustomerPassword());
		logger.debug("총 검증 실패 개수 : " + errors.getErrorCount());
		if (errors.hasErrors())
		{
			logger.debug("등록실패");
			return "/WEB-INF/view/join.jsp";
		} else
		{
			logger.debug("customer DB에 등록");
			customerService.addCustomer(customer);
			return "/WEB-INF/view/index.jsp";
		}
	}
}