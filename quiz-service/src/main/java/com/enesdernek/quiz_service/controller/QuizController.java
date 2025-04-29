package com.enesdernek.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enesdernek.quiz_service.dto.QuestionDto;
import com.enesdernek.quiz_service.dto.QuizDtoIU;
import com.enesdernek.quiz_service.service.concretes.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping
	public ResponseEntity<String> createQuiz(@RequestBody QuizDtoIU quizDtoIU) {
		return new ResponseEntity<String>(this.quizService.createQuiz(quizDtoIU),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<QuestionDto>> getQuizQuestions(@PathVariable Long id){
		return new ResponseEntity<List<QuestionDto>>(this.quizService.getQuizQuestions(id),HttpStatus.OK);
	}
	

}
