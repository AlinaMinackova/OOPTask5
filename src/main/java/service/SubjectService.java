package service;

import exception.IncorrectDurationException;
import model.subject.Subject;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class SubjectService {


    public void setDuration(Subject subject, Integer duration){
        isDataValid(duration);
        subject.setDuration(duration);
    }

    private void isDataValid(Integer duration){
        if (duration <= 0 || duration > 11){
            throw new IncorrectDurationException("Длительность преподавания дисциплина не может быть <= 0 или > 11");
        }
    }
}
