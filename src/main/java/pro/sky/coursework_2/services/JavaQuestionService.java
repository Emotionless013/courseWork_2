package pro.sky.coursework_2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework_2.Question;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        questions.add(questionToAdd);
        return questionToAdd;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> temp = new ArrayList<>(questions);
        return temp.get(random.nextInt(temp.size()));
    }
}
