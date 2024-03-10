package com.exam.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.model.exam.Question;
import com.exam.examserver.service.QuestionService;
import com.exam.examserver.service.QuizService;
import com.exam.examserver.model.exam.Quiz;
import java.util.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question Question){
		Question QuestionResponse = this.questionService.addQuestion(Question);
		return ResponseEntity.ok(QuestionResponse);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Question Question){
		Question QuestionResponse = this.questionService.updateQuestion(Question);
		return ResponseEntity.ok(QuestionResponse);
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
//		Quiz quiz = new Quiz();
//		quiz.setqId(qid);
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);
		Quiz quiz = this.quizService.getQuiz(qid);
		
		Set<Question> questions = quiz.getQuestions();
		List list = new ArrayList(questions);
		if(list.size()> Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions())+1);
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuestion(@PathVariable("qid") Long qid) {
		 this.questionService.deleteQuestion(qid);
	}

}
