package model.teacher;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Type;
import model.subject.Subject;

import java.util.List;

@NoArgsConstructor
@Slf4j
public abstract class Teacher {

    public abstract Type getTeacherType();
    public abstract void assignSubject(Subject subject);
    public abstract List<Subject> getSubjects();
    public abstract void clearSubjects();
    public void log(String message){
        log.info(message);
    }
}
