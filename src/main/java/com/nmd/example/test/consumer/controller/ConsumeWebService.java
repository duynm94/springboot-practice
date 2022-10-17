package com.nmd.example.test.consumer.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nmd.example.test.dto.UserDTO;

@RestController
@RequestMapping("/api/consumer")
public class ConsumeWebService {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/template/users")
	public String getUserList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.GET, entity, String.class).getBody();
	}
	
	/*@GetMapping("/template/user/{id}")
	public UserDTO getUser(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UserDTO userDTO = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id, UserDTO.class);
		return userDTO;
	}*/
	
	@GetMapping("/template/user/{id}")
	public String getUser(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + id, HttpMethod.GET, entity, String.class).getBody();
	}
	
	@PostMapping("/template/user")
	public String newUser(@RequestBody UserDTO userDTO) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(userDTO, headers);

		return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/", HttpMethod.POST, entity, String.class).getBody();
	}


	/*@RequestMapping(value = "/template/products", method = RequestMethod.POST)
	public String createProducts(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange("http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
	}

	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}
	
	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}*/
}
