package com.exam.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examserver.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
