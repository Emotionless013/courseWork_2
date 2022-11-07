package pro.sky.coursework_2.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework_2.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {
    public JavaQuestionService javaService = new JavaQuestionService();
    Question defaultQuestion = new Question("Zero", "Zero");

    @BeforeEach
    public void addDefaultQuestion() {
        javaService.add(defaultQuestion);
    }

    @Test
    public void returnsOneOneAfterAddition() {
        Question q = new Question("One", "One");
        assertEquals(q, javaService.add(q));
        assertEquals(q, javaService.add("One", "One"));
        assertEquals(2, javaService.getAll().size());
    }

    @Test
    public void returnsOneOneAfterRemoval() {
        assertEquals(defaultQuestion, javaService.remove(defaultQuestion));
        assertEquals(0, javaService.getAll().size());
    }

    @Test
    public void returnsWholeCollectionWithGetAll() {
        Set<Question> test = new HashSet<>();
        test.add(defaultQuestion);
        assertEquals(test, javaService.getAll());
    }

    @Test
    public void returnsZeroWithGetRandom() {
        assertEquals(defaultQuestion, javaService.getRandomQuestion());
    }
}
