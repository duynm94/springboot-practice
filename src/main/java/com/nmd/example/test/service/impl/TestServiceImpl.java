package com.nmd.example.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nmd.example.test.dto.TestDTO;
import com.nmd.example.test.entity.TestEntity;
import com.nmd.example.test.repository.TestRepository;
import com.nmd.example.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;

	@Override
	public TestDTO getHello() {
		List<TestEntity> testEntitys = (List<TestEntity>) testRepository.findAll();
		if (CollectionUtils.isEmpty(testEntitys)) {
			return new TestDTO();
		}

		TestDTO testDTO = new TestDTO();
		testDTO.setId(testEntitys.get(0).getId());
		testDTO.setMsg(testEntitys.get(0).getMsg());
		return testDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public TestDTO insertTest(TestDTO input) {
		TestEntity testEntity = new TestEntity();
		testEntity.setMsg(input.getMsg());
		TestEntity testEntitySave = testRepository.save(testEntity);
		
		TestDTO testDTO = new TestDTO();
		testDTO.setId(testEntitySave.getId());
		testDTO.setMsg(testEntitySave.getMsg());
		return testDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public TestDTO updateTest(TestDTO input) {
		Optional<TestEntity> testEntityOpt = testRepository.findById(input.getId());
		if (testEntityOpt.isPresent()) {
			TestEntity testEntity = testEntityOpt.get();
			testEntity.setMsg(input.getMsg());
			testRepository.save(testEntity);
			return input;
		}
		return null;
	}

	@Override
	public List<TestDTO> getTests(String msg) {
		List<TestDTO> result = new ArrayList<>();
		List<TestEntity> testEntities = (List<TestEntity>) testRepository.findAll();
		if (CollectionUtils.isEmpty(testEntities)) {
			return result;
		}

		for (TestEntity entity : testEntities) {
			TestDTO testDTO = new TestDTO();
			testDTO.setId(entity.getId());
			testDTO.setMsg(entity.getMsg());
			result.add(testDTO);
		}
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteById(Integer id) {
		testRepository.deleteById(id);
	}

}
