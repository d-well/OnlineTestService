package com.test.DTO;

import java.io.Serializable;
import java.time.LocalDate;

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
public class TestCreationDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private long testGenId;
	private String createdBy;
	private String question;
	private LocalDate date;
	private TestAnswerDataDTO options;
}
