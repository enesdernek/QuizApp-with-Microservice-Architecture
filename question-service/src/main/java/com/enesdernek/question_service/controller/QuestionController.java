package com.enesdernek.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enesdernek.question_service.dto.QuestionDto;
import com.enesdernek.question_service.dto.QuestionDtoIU;
import com.enesdernek.question_service.model.Response;
import com.enesdernek.question_service.service.concretes.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<QuestionDto> add(@RequestBody QuestionDtoIU questionDtoIU){
		return new ResponseEntity<QuestionDto>(this.questionService.add(questionDtoIU),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-random-questions-for-quiz")
	public ResponseEntity<List<Long>> getRandomQuestionsForQuiz(@RequestParam int questionNumber) {
		return new ResponseEntity<List<Long>>(this.questionService.getRandomQuestionsForQuiz(questionNumber),HttpStatus.OK);
	}
	
	@PostMapping("/get-questions-by-id")
	public ResponseEntity<List<QuestionDto>> getQuestionsById(@RequestBody List<Long> questionIds){
		return new ResponseEntity<List<QuestionDto>>(this.questionService.getQuestionsById(questionIds),HttpStatus.OK);
	}
	
	@PostMapping("/get-score")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return new ResponseEntity<Integer>(this.questionService.getScore(responses),HttpStatus.OK);
	}
	
	

}
