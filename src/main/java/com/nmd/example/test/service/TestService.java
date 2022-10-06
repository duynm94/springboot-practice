package com.nmd.example.test.service;

import java.util.List;

import com.nmd.example.test.dto.TestDTO;

public interface TestService {

	TestDTO getHello();

	TestDTO insertTest(TestDTO input);
	
	TestDTO updateTest(TestDTO input);
	
	List<TestDTO> getTests(String msg);
	
	void deleteById(Integer id);
	
}
