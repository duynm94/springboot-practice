package com.nmd.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// RestController: la 1 annotation đánh dấu class là controller, trong controller này sẽ thiết kế các api theo kiến trúc REST: PUT, POST, GET, DELETE
// RestController = Controller + Response: phục vụ tạo nên webservice, không làm việc với View

// Controller: la 1 annotaion đánh dấu class là controller, tương tác với view để trả về data, thường sử dụng trong Spring MVC

@Controller
public class WebController {

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
}
