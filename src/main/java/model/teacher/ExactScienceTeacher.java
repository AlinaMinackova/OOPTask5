package model.teacher;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import model.Type;
import model.subject.Subject;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class ExactScienceTeacher extends Teacher{
    @NonNull
    private String FIO;
    private List<Subject> subjects;
    private final Type teacherType;

    public ExactScienceTeacher(String FIO, Type teacherType){
        this.FIO = FIO;
        this.teacherType = teacherType;
        this.subjects = new ArrayList<>();
    }

    @Override
    public Type getTeacherType() {
        return teacherType;
    }

    @Override
    public void assignSubject(Subject subject) {
        log.info("добавлен предмет {}", subject.getName());
        subjects.add(subject);
    }

    @Override
    public List<Subject> getSubjects() {
        log.info("предметы SocialScienceTeacher");
        return subjects;
    }

    @Override
    public void clearSubjects() {
        this.subjects = new ArrayList<>();
    }

    private void setFIO(String FIO){
        this.FIO = FIO;
    }
}
