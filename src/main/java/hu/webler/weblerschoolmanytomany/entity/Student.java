package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.entity.base.Identifier;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Identifier {

    private String firstname;
    private String midName;
    private String lastName;
    private String cell;
    private String email;
    private LocalDate dateOffBirth;

    @CreationTimestamp
    private LocalDateTime registrationDate = LocalDateTime.now();
}
