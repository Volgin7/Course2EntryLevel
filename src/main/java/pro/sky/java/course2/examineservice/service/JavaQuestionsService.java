package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.Collection;

public interface JavaQuestionsService {

    Question add(String question, String answer);
    Question remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
