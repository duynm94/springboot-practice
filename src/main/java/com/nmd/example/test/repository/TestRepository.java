package com.nmd.example.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nmd.example.test.entity.TestEntity;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Integer> {

}
