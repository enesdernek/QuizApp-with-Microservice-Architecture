package com.enesdernek.question_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

	private Long id;

	private String question;

	private String firstOption;

	private String secondOption;

	private String thirdOption;

	private String fourthOption;

}
