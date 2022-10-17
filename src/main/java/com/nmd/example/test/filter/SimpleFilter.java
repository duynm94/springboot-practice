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

//By using filter, we can perform two operations at two instances:
//	- Before sending the request to the controller
//	- Before sending a response to the client.
// Can have multi Filter
// Filter and Interceptor is the same but filter execute before dispacher servelet and interceptor is after.
// Filter is class of Servlet and Intercepter more strong
@Component
public class SimpleFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		log.info("======doFilter======");
		log.info("Remote Host:" + request.getRemoteHost());
		log.info("Remote Host:" + request.getRemoteAddr());
		log.info("======doFilter======");
		filterchain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
	}

}
