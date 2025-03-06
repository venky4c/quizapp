package com.telusuko.quizapp.controller;

import com.telusuko.quizapp.entity.Question;
import com.telusuko.quizapp.service.QuestionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    Logger log = LoggerFactory.getLogger(QuestionsService.class);
    @Autowired
    QuestionsService service;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        service.addQuestion(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        service.updateQuestion(question);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public void deleteQuestions(){
        service.deleteQuestions();
    }


}
