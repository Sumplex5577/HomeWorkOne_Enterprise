package com.example.homeworkone;

import com.example.homeworkone.entity.Student;
import com.example.homeworkone.service.QuizService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        QuizService service = context.getBean(QuizService.class);
        service.executeQuiz(new Student());
    }
}
