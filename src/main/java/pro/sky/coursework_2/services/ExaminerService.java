package pro.sky.coursework_2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework_2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
