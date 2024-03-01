package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.entity.base.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {

    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
