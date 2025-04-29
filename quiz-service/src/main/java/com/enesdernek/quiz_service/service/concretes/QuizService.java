package com.enesdernek.quiz_service.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enesdernek.quiz_service.dto.QuestionDto;
import com.enesdernek.quiz_service.dto.QuizDtoIU;
import com.enesdernek.quiz_service.feign.QuizInterface;
import com.enesdernek.quiz_service.model.Quiz;
import com.enesdernek.quiz_service.repository.QuizRepository;
import com.enesdernek.quiz_service.service.abstracts.IQuizService;

@Service
public class QuizService implements IQuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuizInterface quizInterface;

	@Override
	public String createQuiz(QuizDtoIU quizDtoIU) {
		
		List<Long>questionIds = this.quizInterface.getQuestionsForQuiz(quizDtoIU.getQuestionNumber());
		Quiz quiz = new Quiz();
		quiz.setTitle(quizDtoIU.getTitle());
		quiz.setQuestionIds(questionIds);
		this.quizRepository.save(quiz);
		
		return "Success";
	}

	@Override
	public List<QuestionDto> getQuizQuestions(Long id) {
		
		Quiz quiz = this.quizRepository.findById(id).get();
		List<Long>questionIds = quiz.getQuestionIds();
		
		List<QuestionDto> questionDtos = this.quizInterface.getQuestionsFromId(questionIds);
		
		return questionDtos;
	}
	


}
