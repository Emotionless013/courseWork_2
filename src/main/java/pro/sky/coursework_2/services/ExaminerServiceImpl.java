package pro.sky.coursework_2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework_2.Question;
import pro.sky.coursework_2.exceptions.IncorrectAmountOfQuestions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new IncorrectAmountOfQuestions("В хранилище нет такого количества вопросов");
        }
        if (amount == service.getAll().size()) {
            return service.getAll();
        }
        Set<Question> output = new HashSet<>();
        while (output.size() < amount) {
            output.add(service.getRandomQuestion());
            output.add(service.getRandomQuestion());
        }
        return output;
    }
}
