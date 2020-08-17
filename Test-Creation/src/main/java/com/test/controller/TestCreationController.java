package com.test.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.DAO.TestCreationDAO;
import com.test.DTO.TestCreationDTO;
import com.test.entity.TestCreationEntity;
import com.test.model.TestCreationModel;

@RestController
public class TestCreationController {
	
	@Autowired
	TestCreationDAO testCreationDAO;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TestCreationDTO testCreationDTO;
	
	@GetMapping(path = "/testCreation")
	public String getHomePage() {
		return "Welcome to Test Creation Home Page";
	}
	
	@PostMapping
	(path = "/addQuestion", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestCreationModel> addQuestions(@RequestBody TestCreationModel testCreationObj) {
		
		// To ensure that model strictly matches to dto object
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		testCreationDTO =modelMapper.map(testCreationObj, TestCreationDTO.class);
		TestCreationDTO returnDTO = testCreationDAO.addQuestion(testCreationDTO);
		TestCreationModel returnModel = modelMapper.map(returnDTO, TestCreationModel.class);
		
		return new ResponseEntity<TestCreationModel>(returnModel, HttpStatus.CREATED);
		
	}
	
	@GetMapping(path = "getAllQuestions/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TestCreationDTO> getAllQuestions(@PathVariable(name = "name") String authorName) {
		
		List<TestCreationDTO> testCreationDTO = testCreationDAO.getAllQuestions(authorName);
		
		return testCreationDTO;
		
	}
	
	@GetMapping(path = "deleteQuestionById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TestCreationDTO> deleteQuestionById(@PathVariable(name = "id") long id) {
		
		List<TestCreationDTO> testCreationDTO = testCreationDAO.deleteQuestionById(id);
		if(!(testCreationDTO.isEmpty() || testCreationDTO == null))
			return testCreationDTO;
		else return null;
	}
}
