package pro.sky.java.course2.examineservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.service.JavaQuestionService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final JavaQuestionService serviceJQ;

    public JavaController(JavaQuestionService serviceJQ) {
        this.serviceJQ = serviceJQ;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return serviceJQ.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return serviceJQ.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return serviceJQ.getAll();
    }

}
