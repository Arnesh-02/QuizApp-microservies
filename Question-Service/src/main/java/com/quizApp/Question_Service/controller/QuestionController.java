package com.quizApp.Question_Service.controller;


import com.quizApp.Question_Service.dto.QuestionDto;
import com.quizApp.Question_Service.dto.ResponseDto;
import com.quizApp.Question_Service.model.Question;
import com.quizApp.Question_Service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizapp/questions")
public class QuestionController {

    @Autowired
    QuestionService serv;

    @GetMapping("/all")
    public List<Question> getAllQuestions(){
        return serv.getAllQuestions();
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return serv.addQuestion(question);
    }

    @GetMapping("/category/{category}")
    public  List<Question> getQuestionByCategory(@PathVariable String category){
        return  serv.getQuestionsByCategory(category);
    }

    @GetMapping("/generate")
    public List<Integer> getQuestionsForQuiz(@RequestParam int noq,@RequestParam String category){
        return serv.getQuestionsForQuiz(noq,category);
    }

    @PostMapping("/calScore")
    public Integer calculateScore(@RequestBody  List<ResponseDto> response){
        return  serv.calculateScore(response);
    }

    @PostMapping("/get")
    public List<QuestionDto> getQnsByQnNo(@RequestBody List<Integer> qns){
        return  serv.getQnsByQnNo(qns);
    }
}
