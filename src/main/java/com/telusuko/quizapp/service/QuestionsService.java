package com.telusuko.quizapp.service;

import com.telusuko.quizapp.entity.Question;
import com.telusuko.quizapp.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsService {



    @Autowired
    QuestionRepository repository;
    private Logger log = LoggerFactory.getLogger(QuestionsService.class);

    public ResponseEntity<List<Question>> getAllQuestions() {

        try {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(repository.findAllByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
    }


public ResponseEntity<String> addQuestion(Question question) {
    try {
        log.info("Question object in service BEFORE save: {}", question); // Log BEFORE
        repository.save(question);
        log.info("Question object in service AFTER save: {}", question); // Log AFTER
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    } catch (Exception e) {
        log.error("Error saving question: {}", e.getMessage(), e);
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
}

    public void deleteQuestions() {
        try {
            repository.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> updateQuestion(Question question) {

        try {
            repository.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error updating question: {}",e.getMessage());
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
