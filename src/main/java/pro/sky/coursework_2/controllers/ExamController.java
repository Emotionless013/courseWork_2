package pro.sky.coursework_2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework_2.Question;
import pro.sky.coursework_2.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    public final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @RequestMapping("get/")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return service.getQuestions(amount);
    }
}
