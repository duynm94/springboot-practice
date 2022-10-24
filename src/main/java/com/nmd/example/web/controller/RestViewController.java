package com.nmd.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nmd.example.product.dto.ProductDTO;

@RestController
public class RestViewController {

	private static List<ProductDTO> products = new ArrayList<>();

	static {
		products.add(new ProductDTO(1, "Nokia"));
		products.add(new ProductDTO(2, "Iphone"));
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<ProductDTO> getProducts() {
		return products;
	}
}
