package model.subject;

import lombok.*;
import model.Type;

@Data
public class Subject {
    @NonNull
    private String name;
    @NonNull
    private Type subjectType;
    @NonNull
    @EqualsAndHashCode.Exclude
    private Integer duration;

    public Subject(@NonNull String name, @NonNull Type subjectType) {
        this.name = name;
        this.subjectType = subjectType;
    }
}
