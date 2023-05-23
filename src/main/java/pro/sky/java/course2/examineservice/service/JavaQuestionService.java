package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questionsList;

    public JavaQuestionService() {
        this.questionsList = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion  = new Question(question,answer);
        if(questionsList.contains(newQuestion)) {
            System.out.println("Contains => null");
            return null;
        }
        questionsList.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionToRemove = new Question(question, answer);
        if (!questionsList.contains(questionToRemove)) {
            System.out.println("NotFound => null");
            return null;
        }
        questionsList.remove(questionToRemove);
        return questionToRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questionsList);
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
