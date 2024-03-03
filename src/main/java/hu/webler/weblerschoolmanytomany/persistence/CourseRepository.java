package hu.webler.weblerschoolmanytomany.persistence;

import hu.webler.weblerschoolmanytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Writer;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
