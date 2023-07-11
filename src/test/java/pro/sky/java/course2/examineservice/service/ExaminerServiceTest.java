package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.exception.NotEnoughQuestionsException;
import pro.sky.java.course2.examineservice.model.Question;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    JavaQuestionsServiceImpl javaService;

    @InjectMocks
    ExaminerServiceImpl examService;

    @Test
    @DisplayName("Test of getQuestions method - exception if not enough questions")
    void getQuestionsExceptionTest() {
        List<Question> javaQuestionsList = new ArrayList<Question>();

        javaQuestionsList.add(new Question("Question 1", "Answer 1"));
        javaQuestionsList.add(new Question("Question 2", "Answer 2"));
        javaQuestionsList.add(new Question("Question 3", "Answer 3"));

        when(javaService.getQuestionsList()).thenReturn(javaQuestionsList);
        // ask for number of questions = 4 > then exist = 3
        Assertions.assertThrows(NotEnoughQuestionsException.class, ()->examService.getQuestions(4));
    }

    @Test
    @DisplayName("Test of getQuestions question method")
    void getQuestionsTest() {
        List<Question> javaQuestionsList = new ArrayList<Question>();

        javaQuestionsList.add(new Question("Question 1", "Answer 1"));
        javaQuestionsList.add(new Question("Question 2", "Answer 2"));
        javaQuestionsList.add(new Question("Question 3", "Answer 3"));

        when(javaService.getQuestionsList()).thenReturn(javaQuestionsList);
        when(javaService.getRandomQuestion()).thenReturn(javaQuestionsList.get(0));

        String expected = javaQuestionsList.get(0).toString();
        String actual = examService.getQuestions(1).get(0).toString();
        Assertions.assertEquals(actual,expected);
        System.out.println(actual + expected);
    }

}
