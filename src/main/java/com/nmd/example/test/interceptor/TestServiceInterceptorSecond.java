package com.nmd.example.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestServiceInterceptorSecond implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TestServiceInterceptorSecond.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("========preHandle========");
		logger.info("========TestServiceInterceptorSecond========");
		logger.info("========preHandle========");
		return true;
	}

	// Before send response from server to client
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("========postHandle========");
		logger.info("========TestServiceInterceptorSecond========");
		logger.info("========postHandle========");

	}

	// After completing the request and response.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		logger.info("========afterCompletion========");
		logger.info("========TestServiceInterceptorSecond========");
		logger.info("========afterCompletion========");
	}
}
