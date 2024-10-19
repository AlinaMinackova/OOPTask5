import exception.IncorrectAssignSubject;
import exception.IncorrectDurationException;
import model.Type;
import model.subject.Subject;
import model.teacher.SocialScienceTeacher;
import model.teacher.Teacher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.SubjectService;
import service.TeacherService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeacherServiceTest {

    private static final TeacherService teacherService = new TeacherService();
    private static final List<Subject> subjects = new ArrayList<>();
    private static final List<Teacher> teachers = new ArrayList<>();

    @BeforeAll
    static void setUp() {

        subjects.add(new Subject("Математика", Type.EXACT));
        subjects.add(new Subject("Литература", Type.HUMANITARIAN));
        subjects.add(new Subject("География", Type.NATURAL));
        subjects.add(new Subject("Обществознание", Type.SOCIAL));
        teachers.add(new SocialScienceTeacher("Орлов Генадий Николаевич", Type.EXACT));
        teachers.add(new SocialScienceTeacher("Костин Семён Викторович", Type.HUMANITARIAN));
        teachers.add(new SocialScienceTeacher("Плеханова Анна Дмитриевна", Type.NATURAL));
        teachers.add(new SocialScienceTeacher("Анисимов Александр Сергеевич", Type.SOCIAL));
    }

    @AfterEach
    void clearShelves() {
        teachers.forEach(Teacher::clearSubjects);
    }

    @Test
    @DisplayName("Валидно, добавление без ошибок")
    void ValidAssignSubjectTest() {
        for (int i = 0; i < teachers.size(); i++) {
            int finalI = i;
            assertDoesNotThrow(() ->
                    teacherService.assignSubject(
                            subjects.get(finalI),
                            teachers.get(finalI)
            ));
        }
        for (Teacher teacher: teachers){
            assertEquals(teacher.getSubjects().size(), 1);
        }
    }

    @Test
    @DisplayName("Назначаем нужному учителю")
    void assignSubjectTest() {
        for (int i = 0; i < teachers.size(); i++) {
            teacherService.assignSubject(subjects.get(i), teachers.get(teachers.size() - 1 - i));
        }
        for (Teacher teacher: teachers){
            assertEquals(teacher.getSubjects().size(), 1);
        }
    }


}