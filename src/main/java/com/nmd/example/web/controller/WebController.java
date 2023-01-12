package com.nmd.example.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// RestController: la 1 annotation đánh dấu class là controller, trong controller này sẽ thiết kế các api theo kiến trúc REST: PUT, POST, GET, DELETE
// RestController = Controller + Response: phục vụ tạo nên webservice, không làm việc với View

// Controller: la 1 annotaion đánh dấu class là controller, tương tác với view để trả về data, thường sử dụng trong Spring MVC

@Controller
public class WebController {
	
	@Autowired
	private MessageSource messageSource;
	

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/locale")
	public String locale(Model model, HttpServletRequest request) {
		String msg = messageSource.getMessage("hello", null, "default message", request.getLocale());
		model.addAttribute("msg", msg);
		return "locale";
	}
}
