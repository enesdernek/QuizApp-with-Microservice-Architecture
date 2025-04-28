package com.enesdernek.question_service.service.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enesdernek.question_service.dto.QuestionDto;
import com.enesdernek.question_service.dto.QuestionDtoIU;
import com.enesdernek.question_service.model.Question;
import com.enesdernek.question_service.model.Response;
import com.enesdernek.question_service.repository.QuestionRepository;
import com.enesdernek.question_service.service.abstracts.IQuestionService;

@Service
public class QuestionService implements IQuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public QuestionDto convertQuestionToQuestionDto(Question question) {
		QuestionDto questionDto = new QuestionDto();
		BeanUtils.copyProperties(question, questionDto);
		return questionDto;
	}

	@Override
	public QuestionDto add(QuestionDtoIU questionDtoIU) {
		Question question = new Question();
		BeanUtils.copyProperties(questionDtoIU, question);
		this.questionRepository.save(question);
		
		QuestionDto questionDto = convertQuestionToQuestionDto(question);
		
		return questionDto;
	}

	@Override
	public List<Long> getRandomQuestionsForQuiz(int questionNumber) {
		
		List<Long>questionIds = this.questionRepository.generateRandomQuestions(questionNumber);

		return questionIds;
	}
	
	@Override
	public List<QuestionDto> getQuestionsById(List<Long> questionIds) {
		
		List<Question> questions = new ArrayList<>();
		
		for(Long id:questionIds) {
			Question question = this.questionRepository.findById(id).get();
			questions.add(question);
		}
		
		List<QuestionDto>questionDtos = new ArrayList<>();
		
		for(Question question:questions) {
			QuestionDto questionDto = convertQuestionToQuestionDto(question);
			questionDtos.add(questionDto);
		}
		
		return questionDtos;
	}


	@Override
	public Integer getScore(List<Response> responses) {
		
		int rightAnswer = 0;
		
		for(Response response:responses) {
			Question question = this.questionRepository.findById(response.getId()).get();
			
			if(response.getResponse().equals(question.getRightAnswer())) {
				rightAnswer++;
			}
			
		}
		return rightAnswer;
	}

	

}
