package com.nmd.example.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nmd.example.test.interceptor.TestServiceInterceptor;

@Component
public class TestServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	TestServiceInterceptor testServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testServiceInterceptor);
	}
}
