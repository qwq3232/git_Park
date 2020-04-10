package kosta.qorder.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import kosta.qorder.controller.IndexController;

public class AdminIntercepter implements HandlerInterceptor
{
	private static Logger logger = Logger.getLogger(AdminIntercepter.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		logger.debug("AdminIntercepter.preHandle()");
		HttpSession session = request.getSession();
		if(session.getAttribute("restaurantId")==null && session.getAttribute("customerType")!=null)
		{
			throw new ModelAndViewDefiningException(new ModelAndView("admin/database/insert/restaurant.tiles"));
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

}
