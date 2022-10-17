package com.nmd.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

// ApplicationRunner: println statement is executed after the Tomcat started, param in run method is String array and other param
//@SpringBootApplication
//public class SpringDemoApplication extends ApplicationRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringDemoApplication.class, args);
//	}
//
//	@Override
//	public void run(ApplicationArguments arg0) throws Exception {
//		System.out.println("Hello World from Application Runner");
//	}
//
//}

// CommandLineRunner: println statement is executed after the Tomcat started, param in run method is String array
//@SpringBootApplication
//public class SpringDemoApplication extends CommandLineRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringDemoApplication.class, args);
//	}
//
//	@Override
//	public void run(String... arg0) throws Exception {
//		System.out.println("Hello world from Command Line Runner");
//	}
//
//}

// to build war and deploy in tomcat
//@SpringBootApplication
//public class SpringDemoApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringDemoApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringDemoApplication.class, args);
//	}
//	
//}
