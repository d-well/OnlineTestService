package com.test.model;

import com.test.DTO.TestAnswerDataDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestCreationModel {
	
	private String createdBy;
	private String question;
	private TestAnswerDataDTO options;
	
}
