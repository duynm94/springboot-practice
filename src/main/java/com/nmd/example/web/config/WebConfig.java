package com.nmd.example.web.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

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
	
	
	//Bean messageSource sẽ thực hiện khai báo các file properties
	//trong ví dụ này mình khai báo các file properties nằm ở folder i18n, có tên bắt đầu bằng messages
	//Bean localeResolver sẽ xác định ngôn ngữ hiển thị trên view bằng cách nào, ví dụ thông qua session, qua cookies
	//Trong ví dụ này, mình sẽ xác định ngôn ngữ hiển thị qua cookies với biến myAppLocaleCookies lưu trên trình duyệt
	//Method addInterceptors sẽ xác định thay đổi ngôn ngữ hiển thị thông qua param name nào trên trình duyệt. Ví dụ trên URL có param: ?language=en thì tiếng anh sẽ được hiển thị
	
	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieDomain("myAppLocaleCookie");
		resolver.setDefaultLocale(Locale.ENGLISH);
		
		// 60 MINUTES
		resolver.setCookieMaxAge(60*60);
		return resolver;
	}
	
	@Bean(name = "messageSource")
    public MessageSource getMessageResource()  {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
         
        // Đọc vào file i18n/messages_xxx.properties
        // Ví dụ: i18n/messages_en.properties
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("language");
        registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
    }

}
