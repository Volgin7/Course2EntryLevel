package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.model.Question;

import java.util.Collection;

public class JavaQuestionsServiceTest {
    private JavaQuestionsService javaService;
    @BeforeEach
    public void init() {
        javaService = new JavaQuestionsServiceImpl();
        javaService.add("Question 1","Answer 1");
        javaService.add("Question 2","Answer 2");
    }
    @Test
    @DisplayName("Test of add java question method. Positive")
    void addPositiveTest() {
        Question newQuestion = new Question("New question 1", "New answer 1");
        Assertions.assertTrue(javaService.add("New question 1", "New answer 1").equals(newQuestion));
    }
    @Test
    @DisplayName("Test of add java question method. Negative")
    void addNegativeTest() {
        Assertions.assertNull(javaService.add("Question 2","Answer 2"));
    }
    @Test
    @DisplayName("Test of remove java question method. Positive")
    void removePositiveTest() {
        Question newQuestion = new Question("Question 1", "Answer 1");
        Assertions.assertTrue(javaService.remove("Question 1", "Answer 1").equals(newQuestion));
    }
    @Test
    @DisplayName("Test of remove java question method. Negative")
    void removeNegativeTest() {
        Assertions.assertNull(javaService.remove("Another Question","Another Answer"));
    }

    @Test
    @DisplayName("Test of getAll java question method")
    void getAllTest() {
        Collection<Question> allQuestions;
        allQuestions = javaService.getAll();
        Assertions.assertEquals(2, allQuestions.size());
        Assertions.assertNotNull (allQuestions);
    }
    @Test
    @DisplayName("Test of getRandom java question method")
    void getRandomQuestionTest() {
        Assertions.assertNotNull (javaService.getRandomQuestion());
    }
}
