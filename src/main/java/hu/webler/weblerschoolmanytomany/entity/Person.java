package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.entity.base.Identifier;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
public class Person extends Identifier {

    private String firstname;
    private String midName;
    private String lastName;
    private String cell;
    private String email;
    private LocalDate dateOffBirth;
}