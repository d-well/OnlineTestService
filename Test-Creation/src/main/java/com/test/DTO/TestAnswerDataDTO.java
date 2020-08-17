package com.test.DTO;

import org.springframework.stereotype.Component;

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
@Component
public class TestAnswerDataDTO {
	
	private String optionOne;
	private String optionTwo;
	private String optionThree;
	private String optionFour;
	private String correctAnswer;



}
