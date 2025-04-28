package com.enesdernek.question_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String question;
	
	private String firstOption;
	
	private String secondOption;
	
	private String thirdOption;
	
	private String fourthOption;
	
	private String rightAnswer;

}
