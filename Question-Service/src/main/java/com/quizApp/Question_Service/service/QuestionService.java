package com.quizApp.Question_Service.service;


import com.quizApp.Question_Service.dto.QuestionDto;
import com.quizApp.Question_Service.dto.ResponseDto;
import com.quizApp.Question_Service.model.Question;
import com.quizApp.Question_Service.repositry.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;


    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public String addQuestion(Question question) {
        questionRepo.save(question);
        return "Question Added Successfully..!";
    }

    public List<Question> getQuestionsByCategory(String category){
        return  questionRepo.findByCategory(category);
    }

    public List<Integer> getQuestionsForQuiz(int noq, String category) {
        return  questionRepo.findRandomQuestionsByCategory(category,noq);
    }

    public Integer calculateScore(List<ResponseDto> response) {
        int score=0;
        for(ResponseDto i:response){
            Question question=questionRepo.findByQn_no(i.getQno());
            System.out.println(i.getSelectedOption()+"  "+question.getAnswer() );
            if(i.getSelectedOption().equals(question.getAnswer())){
                score++;
            }
        }
        return score;
    }

    public List<QuestionDto> getQnsByQnNo(List<Integer> qns) {
        List<QuestionDto> qnsForUser=new ArrayList<>();
        for(Integer i: qns){
            Question question=questionRepo.getById(i);
            QuestionDto questionDto =new QuestionDto();
            questionDto.setQuestion(question.getQuestion());
            questionDto.setLevel(question.getLevel());
            questionDto.setOption1(question.getOption1());
            questionDto.setOption2(question.getOption2());
            questionDto.setOption3(question.getOption3());
            questionDto.setOption4(question.getOption4());
            questionDto.setQnNo(question.getQnNo());
            qnsForUser.add(questionDto);

        }
        return  qnsForUser;
    }
}
