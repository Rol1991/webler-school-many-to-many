package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.entity.base.Identifier;
import hu.webler.weblerschoolmanytomany.entity.base.Person;
import hu.webler.weblerschoolmanytomany.value.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Student extends Person {

    @CreationTimestamp
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    private boolean isPaid = false;
}
