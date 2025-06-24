package com.quizApp.Quiz_Service.model;

import jakarta.persistence.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int quizId;
    private String title;

    public List<Integer> getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(List<Integer> questionsId) {
        this.questionsId = questionsId;
    }

    @ElementCollection
    private List<Integer> questionsId;

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
