package com.telusuko.quizapp.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Quiz {

    public Quiz() {}

    public Quiz(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    @ManyToMany
    private List<Question> questions;

}
