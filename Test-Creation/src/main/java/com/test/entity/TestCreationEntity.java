package com.test.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TEST_QUESTIONS")
public class TestCreationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "TEST_GEN_ID", updatable = false, nullable = false)
	private long testGenId;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "DATE")
	private LocalDate date;
	
	@Column(name = "QUESTIONS")
	private String question;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ANSWER_GEN_ID")
	private TestAnswerDataEntity options;
}
