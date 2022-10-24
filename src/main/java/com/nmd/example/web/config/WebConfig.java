package com.nmd.example.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// De nhan css or config khac thi can khai bao 1 class Config vs annotation la @Configuration de dang ki css
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/resources/bootstrap/**")
		// .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
		// registry.addResourceHandler("/resources/jquery/**")
		// .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.0.0/");
		registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
	}

}
