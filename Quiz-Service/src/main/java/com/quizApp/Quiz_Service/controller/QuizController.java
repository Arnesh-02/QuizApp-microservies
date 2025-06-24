package com.quizApp.Quiz_Service.controller;



import com.quizApp.Quiz_Service.dto.QuestionDto;
import com.quizApp.Quiz_Service.dto.ResponseDto;
import com.quizApp.Quiz_Service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizapp")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/quiz/new")
    public String createQuiz(@RequestParam String category,@RequestParam String title,@RequestParam Integer no){
        return quizService.createQuiz(category,title,no);
    }

    @GetMapping("quiz/get/{id}")
    public List<QuestionDto> getAllQuestionByQuizId(@PathVariable Integer id){
        return  quizService.getAllQuestionByQuizId(id);
    }

    @PostMapping("quiz/submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id,@RequestBody List<ResponseDto> responses){
        return  quizService.calculateScore(id,responses);
    }

}
