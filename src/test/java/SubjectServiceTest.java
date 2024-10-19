import exception.IncorrectDurationException;
import model.Type;
import model.subject.Subject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.SubjectService;
import service.TeacherService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubjectServiceTest {

    private static final Integer VALID_DURATION = 5;
    private static final Integer INVALID_DURATION = 0;
    private static final Integer INVALID_DURATION2 = 12;
    private final Subject subject = new Subject("Литература", Type.HUMANITARIAN);
    private final SubjectService subjectService = new SubjectService();

    @Test
    @DisplayName("Продолжительность преподавания предмета валидная")
    void setValidDurationTest() {
        subjectService.setDuration(subject, VALID_DURATION);
        assertEquals(subject.getDuration(), VALID_DURATION);
    }

    @Test
    @DisplayName("Продолжительность преподавания предмета невалидная")
    void setInvalidDurationTest() {
        assertThrows(IncorrectDurationException.class,
                () -> subjectService.setDuration(subject, INVALID_DURATION));
        assertThrows(IncorrectDurationException.class,
                () -> subjectService.setDuration(subject, INVALID_DURATION2));
    }
}
