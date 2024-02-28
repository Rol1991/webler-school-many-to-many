package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.entity.base.Identifier;
import jakarta.persistence.CascadeType;
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
public class School extends Identifier {

    private String name;
    private String address;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Course> courses;
}
