package com.telusuko.quizapp.controller;

import com.telusuko.quizapp.entity.Question;
import com.telusuko.quizapp.entity.QuestionWrapper;
import com.telusuko.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService service;

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return service.getQuizQuestions(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        service.createQuiz(category,numQ,title);
        return new ResponseEntity<>("I am here >>>>>>>>>>>>>>>", HttpStatus.OK);
    }

}
