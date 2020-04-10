package kosta.qorder.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import kosta.qorder.controller.IndexController;

public class LoginIntercepter implements HandlerInterceptor
{
	/*
	 * Interceptor - Spring MVC에서 Controller(Handler)들의 공통 로직을 처리하기
	 * 				 위한 Component로 handler 처리 전후로 호출 된다.
	 * 
	 * 구현
	 * 1. Interceptor 클래스 생성
	 * 	- HandlerInterceptor(I) 를 implements : 모든 callback 메소드 overriding
	 * 	- HandlerInterceptorAdapter(C)를 extends : 
	 * 										  필요한 callback 메소드만 overriding.
	 *  - overriding callback 메소드
	 *  	+ preHandle() - handler(Controller) 호출 전에 호출되는 메소드
	 *  	+ postHandle() - handler(Controller) 처리 후에 호출 되는 메소드
	 *  	+ afterCompletion() - View가 실행 된 후에 호출되는 메소드
	 *  						(사용자 요청에 대한 모든 처리 종료 후 호출됨)
	 *  
	 * 2. Spring 설정파일에 등록
	 * 	<mvc:interceptors> -> <mvc:interceptor> 태그를 이용해 등록.
	 * 		- Interceptor클래스, 언제 호출될지(url 패턴)
	 */
	private static Logger logger = Logger.getLogger(IndexController.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		logger.debug("LoginIntercepter.preHandle()");
		HttpSession session = request.getSession();
		if(session.getAttribute("customerId")==null)
		{
			throw new ModelAndViewDefiningException(new ModelAndView("/index.do"));
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
		//logger.debug("Intercepter.postHandle() - "+modelAndView.getViewName());	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		//logger.debug("Intercepter.afterCompletion()");
	}

}
