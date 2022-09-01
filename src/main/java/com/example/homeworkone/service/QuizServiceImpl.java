package com.example.homeworkone.service;

import com.example.homeworkone.entity.Quiz;
import com.example.homeworkone.entity.Student;
import com.example.homeworkone.utility.QuizMapping;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//@Slf4j
public class QuizServiceImpl implements QuizService {

    private QuizMapping quizMapping;

    public QuizServiceImpl(QuizMapping quizMapping) {
        this.quizMapping = quizMapping;
    }

    public List<Quiz> getQuestions() {
        return quizMapping.questionReader();
    }

    private static int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers) {
        int point = 0;
        for (int i = 0; i < studentsAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(studentsAnswers.get(i))) {
                point++;
            }
        }
        return point;
    }

    public void executeQuiz(Student student) {

        List<Quiz> questions = this.getQuestions();
        List<Integer> rightAnswers = new ArrayList<>();
        List<Integer> studentAnswers = new ArrayList<>();
        int answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String result = scanner.nextLine();
        student.setName(result);
        System.out.println("Enter your surname:");
        result = scanner.nextLine();
        student.setSurname(result);
        for (Quiz question : questions) {
            System.out.println(question);
            answer = scanner.nextInt();
            studentAnswers.add(answer);
            rightAnswers.add(question.getRightAnswer());
            student.setPoint(checkAnswers(studentAnswers, rightAnswers));
        }
        System.out.println(student);
    }

}