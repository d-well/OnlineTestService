package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.TestCreationEntity;

@Repository
public interface TestCreationRepository extends JpaRepository<TestCreationEntity, Long>{

	public List<TestCreationEntity> findByCreatedBy(String createdBy);
	
	public TestCreationEntity findById(long id);
	
}
