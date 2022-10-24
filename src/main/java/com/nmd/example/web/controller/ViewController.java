package com.nmd.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// Khi su dung ajax call backend de tuong tac voi fronend -> Tao trong Controller nhung api de redirect to file html, Tao RestController de ajax call den va tra ve data mong muon
@Controller
public class ViewController {

	@RequestMapping("/view-products")
	public String viewProducts() {
		return "view-products";
	}

	@RequestMapping("/add-products")
	public String addProducts() {
		return "add-products";
	}
}
