package com.telusuko.quizapp.repository;

import com.telusuko.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    public List<Question> findAllByCategory(String category);
}
