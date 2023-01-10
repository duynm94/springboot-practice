package com.nmd.example.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nmd.example.test.dto.PatchDTO;
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

	// http://localhost:9091/api/test/view/111,555/msg
	@RequestMapping(value = { "/hello", "/hello-port", "page*", "view/*,**/msg" }, method = RequestMethod.GET)
	public String getHelloWorld() {
		log.debug("This is log debug."); // not display
		log.info("This is log info.");
		log.error("This is log error.");
		log.warn("This is log warn.");
		// return "Hello";
		return "Hello" + " " + port;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public TestDTO test() {
		return testService.getHello();
	}

	@CrossOrigin
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

	@RequestMapping(value = "/prod", produces = { "application/JSON" })
	@ResponseBody
	public String getProduces() {
		return "Produces attribute";
	}

	/*
	 * { "timestamp": "2022-10-10T07:00:46.443+00:00", "status": 415, "error":
	 * "Unsupported Media Type", "path": "/api/test/cons" }
	 */
	@RequestMapping(value = "/cons", consumes = { "application/JSON", "application/XML" })
	public String getConsumes() {
		return "Consumes attribute";
	}

	
	// Request method PATCH simple
	@PatchMapping("/{id}")
	public ResponseEntity<Boolean> updatePartially(@PathVariable(name = "id") int id, @RequestBody PatchDTO dto)
			throws Exception {
		if ("update".equalsIgnoreCase(dto.getOp())) {
			// Execution
			boolean result = testService.partialUpdate(id, dto.getKey(), dto.getValue());
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		} else {
			throw new Exception("Not yet implemented!");
		}
	}
	
}
