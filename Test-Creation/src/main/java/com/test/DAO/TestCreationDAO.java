package com.test.DAO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.DTO.TestCreationDTO;
import com.test.entity.TestCreationEntity;
import com.test.repository.TestCreationRepository;

@Service
public class TestCreationDAO {
	
	@Autowired
	TestCreationRepository testCreationRepository;
	@Autowired
	ModelMapper modelMapper;
	
	public TestCreationDTO addQuestion(TestCreationDTO testCreationDTO) {
		LocalDate date = LocalDate.now();
		
		testCreationDTO.setDate(date);
		
		//TestAnswerDataEntity testAnswerDataEntity = modelMapper.map(testCreationDTO.getOptions(), TestAnswerDataEntity.class);
		TestCreationEntity testCreationEntity = modelMapper.map(testCreationDTO, TestCreationEntity.class);
		//testCreationEntity.setTestAnswerDataEntity(testAnswerDataEntity);
		testCreationRepository.save(testCreationEntity);
		System.out.println("Data saved Success................");
		
		return testCreationDTO;
	}

	public List<TestCreationDTO> getAllQuestions(String authorName) {
		List<TestCreationEntity> testCreationEntity = testCreationRepository.findByCreatedBy(authorName);
		List<TestCreationDTO> testCreationDTO = Arrays.asList(modelMapper.map(testCreationEntity, TestCreationDTO[].class));
		
		return testCreationDTO;
	}

	public List<TestCreationDTO> deleteQuestionById(long id) {
		
		TestCreationEntity testCreationEntity = testCreationRepository.findById(id);
		
		if (testCreationEntity != null) {
			testCreationRepository.deleteById(id);
			System.out.println("author------ " + testCreationEntity.getCreatedBy());
			List<TestCreationDTO> testCreationDTO2 = getAllQuestions(testCreationEntity.getCreatedBy());
			System.out.println("testCreationDTO2  --- " + testCreationDTO2.toString());
			return testCreationDTO2;
		} else
			return null;
	}

}
