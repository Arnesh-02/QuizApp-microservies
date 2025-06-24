package com.quizApp.Question_Service.repositry;

import com.quizApp.Question_Service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.qn_no FROM question q WHERE q.category = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int limit);


    @Query(value = "SELECT * FROM question q WHERE q.qn_no= ?1",nativeQuery = true)
    Question findByQn_no(int qno);
}
