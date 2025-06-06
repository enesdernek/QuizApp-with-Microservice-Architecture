package com.enesdernek.question_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enesdernek.question_service.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	
	@Query(value = "SELECT question.id FROM question ORDER BY RAND() LIMIT :questionNumber", nativeQuery = true)
	public List<Long> generateRandomQuestions(int questionNumber);

}
