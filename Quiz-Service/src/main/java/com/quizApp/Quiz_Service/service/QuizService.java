package com.quizApp.Quiz_Service.service;


import com.quizApp.Quiz_Service.dto.QuestionDto;
import com.quizApp.Quiz_Service.dto.ResponseDto;
import com.quizApp.Quiz_Service.feign.QuizInterface;
import com.quizApp.Quiz_Service.model.Quiz;
import com.quizApp.Quiz_Service.repositry.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

   @Autowired
   QuizRepo quizRepo;

   @Autowired
   QuizInterface quizInterface;



    public String createQuiz(String category, String title, Integer no) {
        Quiz quiz=new Quiz();
        System.out.println(quizInterface.getQuestionsForQuiz(no,category));
        quiz.setQuestionsId(quizInterface.getQuestionsForQuiz(no,category));
        quiz.setTitle(title);
        quizRepo.save(quiz);
        return "Quiz created successfully";
    }

    public List<QuestionDto> getAllQuestionByQuizId(Integer id) {
        Quiz quiz=quizRepo.findById(id).get();
        System.out.println(quiz.getQuestionsId());
        return quizInterface.getQnsByQnNo(quiz.getQuestionsId());
    }

    public Integer calculateScore(Integer quizNo, List<ResponseDto> responses) {
        return 0;
    }
}
