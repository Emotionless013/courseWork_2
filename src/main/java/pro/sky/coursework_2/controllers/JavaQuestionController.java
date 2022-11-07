package pro.sky.coursework_2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework_2.Question;
import pro.sky.coursework_2.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    public final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question temp = new Question(question, answer);
        return service.remove(temp);
    }

    @RequestMapping("")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
