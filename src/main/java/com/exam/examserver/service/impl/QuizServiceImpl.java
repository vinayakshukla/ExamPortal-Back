package com.exam.examserver.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.model.exam.Category;
import com.exam.examserver.model.exam.Quiz;
import com.exam.examserver.repository.CategoryRepository;
import com.exam.examserver.repository.QuizRepository;
import com.exam.examserver.service.*;
@Service
public class QuizServiceImpl implements QuizService {
    
	@Autowired
	private QuizRepository quizRepository;
 	
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return saveQuiz(quiz);
	}
 
	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return saveQuiz(quiz);
	}
 
	private Quiz saveQuiz(Quiz quiz) {
		if (quiz.getCategory() != null) {
			if (quiz.getCategory().getCid() > 0) {
				Category managedCategory = this.categoryRepository.findById(quiz.getCategory().getCid()).orElse(null);
				if (managedCategory != null) {
					quiz.setCategory(managedCategory);
				}
			} else {
				quiz.setCategory(this.categoryRepository.save(quiz.getCategory()));
			}
		}
		if (quiz.getQuestions() != null) {
			quiz.getQuestions().forEach(question -> question.setQuiz(quiz));
		}
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new HashSet<Quiz>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizRepository.getById(quizId);
	}

	@Override
	public void deleteQuiz(Long quizId) {
		this.quizRepository.deleteById(quizId);
		
	}

}
