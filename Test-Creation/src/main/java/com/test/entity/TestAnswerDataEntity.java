package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "ANSWER_DATA")
public class TestAnswerDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANSWER_GEN_ID", updatable = false, nullable = false)
	private int answerGenId;
	
	@Column(name = "OPTION_1")
	private String optionOne;
	
	@Column(name = "OPTION_2")
	private String optionTwo;
	
	@Column(name = "OPTION_3")
	private String optionThree;
	
	@Column(name = "OPTION_4")
	private String optionFour;
	
	@Column(name = "CORRECT_ANSWER")
	@NotNull
	private String correctAnswer;
	
	

}
