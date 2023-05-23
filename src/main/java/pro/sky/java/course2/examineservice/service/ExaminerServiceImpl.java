package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.exception.NotEnoughQuestionsException;
import pro.sky.java.course2.examineservice.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService serviceJQ;
    public ExaminerServiceImpl(JavaQuestionService serviceJQ) {this.serviceJQ = serviceJQ;}

    @Override
    public List getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if(amount>serviceJQ.getQuestionsList().size()) {
            throw new NotEnoughQuestionsException();
        }
        while (questions.size() < amount) {
            questions.add(serviceJQ.getRandomQuestion());
        }
        return List.copyOf(questions);
    }
}
