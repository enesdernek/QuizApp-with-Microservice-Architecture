package com.enesdernek.quiz_service.service.abstracts;

import java.util.List;

import com.enesdernek.quiz_service.dto.QuestionDto;
import com.enesdernek.quiz_service.dto.QuizDtoIU;

public interface IQuizService {
	
	public String createQuiz(QuizDtoIU quizDtoIU);

}
