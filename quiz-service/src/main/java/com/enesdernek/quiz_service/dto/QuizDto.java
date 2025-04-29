package com.enesdernek.quiz_service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {

	private Long id;

	private String title;

	private List<Long> questionIds;

}
