package hu.webler.weblerschoolmanytomany.model;

import hu.webler.weblerschoolmanytomany.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherModel {

    private Long id;
    private String name;
    private List<Course> courses;
}
