package com.enesdernek.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.enesdernek.quiz_service.dto.QuestionDto;
import com.enesdernek.quiz_service.dto.ResponseDto;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

	@GetMapping("question/get-random-questions-for-quiz")
    public List<Long> getQuestionsForQuiz
            (@RequestParam Integer questionNumber );

    @PostMapping("question/getQuestions")
    public List<QuestionDto> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public Integer getScore(@RequestBody List<ResponseDto> responses);
    
}
