package com.enesdernek.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.enesdernek.quiz_service.dto.QuestionDto;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

	@GetMapping("question/get-random-questions-for-quiz")
    public List<Long> getQuestionsForQuiz
            (@RequestParam Integer questionNumber );

    @PostMapping("question/get-questions-by-id")
    public List<QuestionDto> getQuestionsFromId(@RequestBody List<Long> questionIds);


    
}
