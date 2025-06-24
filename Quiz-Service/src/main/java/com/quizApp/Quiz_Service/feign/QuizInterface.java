package com.quizApp.Quiz_Service.feign;

import com.quizApp.Quiz_Service.dto.QuestionDto;
import com.quizApp.Quiz_Service.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("quizapp/questions/generate")
    public List<Integer> getQuestionsForQuiz(@RequestParam int noq, @RequestParam String category);

    @PostMapping("/quizapp/questions/calScore")
    public Integer calculateScore(@RequestBody List<ResponseDto> response);

    @PostMapping("/quizapp/questions/get")
    public List<QuestionDto> getQnsByQnNo(@RequestParam List<Integer> qns);
}
