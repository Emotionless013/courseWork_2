package pro.sky.coursework_2.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework_2.Question;
import pro.sky.coursework_2.exceptions.IncorrectAmountOfQuestions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService service;

    @InjectMocks
    private ExaminerServiceImpl out;

    Question defaultQuestionZero = new Question("Zero", "Zero");
    Question defaultQuestionOne = new Question("One", "One");
    Question defaultQuestionTwo = new Question("Two", "Two");
    Question defaultQuestionThree = new Question("Three", "Three");
    Question defaultQuestionFour = new Question("Four", "Four");
    List<Question> defaultList = new ArrayList<>(List.of(defaultQuestionZero, defaultQuestionOne, defaultQuestionTwo,
            defaultQuestionThree, defaultQuestionFour));

    @Test
    public void returnsCorrectAmountOfQuestions() {
        when(service.getAll()).thenReturn(defaultList);
        when(service.getRandomQuestion()).thenReturn(defaultList.get(0), defaultList.get(1));
        assertEquals(2, out.getQuestions(2).size());
        assertEquals(5, out.getQuestions(5).size());
    }

    @Test
    public void returnsExceptionWithIncorrectAmountOfQuestions() {
        when(service.getAll()).thenReturn(defaultList);
        assertThrows(IncorrectAmountOfQuestions.class, () -> out.getQuestions(10));
    }
}
