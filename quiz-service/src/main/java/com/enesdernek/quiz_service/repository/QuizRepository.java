package com.enesdernek.quiz_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enesdernek.quiz_service.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
