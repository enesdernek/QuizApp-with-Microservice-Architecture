package com.enesdernek.question_service.service.abstracts;

import java.util.List;

import com.enesdernek.question_service.dto.QuestionDto;
import com.enesdernek.question_service.dto.QuestionDtoIU;

public interface IQuestionService {
	
	public QuestionDto add(QuestionDtoIU questionDtoIU);
	
	public List<Long> getRandomQuestionsForQuiz(int questionNumber);
	
	public List<QuestionDto> getQuestionsById(List<Long>questionIds);
	

}
