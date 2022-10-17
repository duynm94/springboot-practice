package com.nmd.example.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleFilterThird implements Filter {

	private static final Logger log = LoggerFactory.getLogger(SimpleFilterThird.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("SimpleFilterThird");
	}
	
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
	}


}
