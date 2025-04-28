package com.enesdernek.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enesdernek.question_service.dto.QuestionDto;
import com.enesdernek.question_service.dto.QuestionDtoIU;
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
	
	@PostMapping("/generate-random-questions")
	public ResponseEntity<List<Long>> generateRandomQuestions(@RequestParam int questionNumber) {
		return new ResponseEntity<List<Long>>(this.questionService.generateRandomQuestions(questionNumber),HttpStatus.OK);
	}

}
