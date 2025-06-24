package com.quizApp.Quiz_Service.repositry;


import com.quizApp.Quiz_Service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
