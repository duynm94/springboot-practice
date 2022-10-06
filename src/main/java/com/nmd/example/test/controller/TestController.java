package com.nmd.example.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nmd.example.test.dto.TestDTO;
import com.nmd.example.test.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController { 
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService testService;
	
	// Read properties from properties file
	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHelloWorld() {
		log.debug("This is log debug."); // not display
		log.info("This is log info.");
		log.error("This is log error.");
		log.warn("This is log warn.");
		//return "Hello";
		return "Hello" + " " + port;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public TestDTO test() {
		return testService.getHello();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TestDTO> getTests(@RequestParam(name = "msg", required = false) String msg) {
		return testService.getTests(msg);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public TestDTO insertTest(@RequestBody TestDTO input) {
		return testService.insertTest(input);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public TestDTO updateTest(@RequestBody TestDTO input) {
		return testService.updateTest(input);
	}
	
	@RequestMapping(value = "/delete-by-id", method = RequestMethod.POST)
	public void deleteTestById(@RequestParam(name = "id", required = true) Integer id) {
		testService.deleteById(id);
	}
}
