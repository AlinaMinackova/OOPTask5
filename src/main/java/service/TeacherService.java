package service;


import exception.IncorrectAssignSubject;
import lombok.extern.slf4j.Slf4j;
import model.subject.Subject;
import model.teacher.Teacher;
import model.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TeacherService {

    private final Map<Type, Teacher> teacherSubjectMap;

    public TeacherService() {
        this.teacherSubjectMap = new HashMap<>();
    }

    public void assignSubject(Subject subject, Teacher teacher) {
        try {
            isRightType(subject.getSubjectType(), teacher.getTeacherType());
            teacher.assignSubject(subject);
            if (!teacherSubjectMap.containsKey(teacher.getTeacherType())){
                teacherSubjectMap.put(teacher.getTeacherType(), teacher);
            }
        } catch (IncorrectAssignSubject e) {
            log.error(e.getMessage());
        } finally {
            Teacher teacher1 = teacherSubjectMap.get(subject.getSubjectType());
            if(teacher1 != null && !teacher1.getSubjects().contains(subject)){
                teacher1.assignSubject(subject);
            } else {
                log.info("Нет учителя, который ведет данный предмет");
            }
        }
    }

    private void isRightType(Type subject, Type teacher) throws IncorrectAssignSubject {
        if (subject != teacher) {
            throw new IncorrectAssignSubject("Нельзя назначить предмет учителю, не ведущему эту дисциплину");
        }
    }


}
