package com.example.homeworkone.service;

import com.example.homeworkone.entity.Quiz;
import com.example.homeworkone.entity.Student;

import java.util.List;

public interface QuizService {
    List<Quiz> getQuestions();
    void executeQuiz(Student student);
}
