package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.persistence.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course findCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.findById(id);
        }
        String message = String.format("Course with id %d not found", id);
        log.info(message);
        throw new NoSuchElementException(message);
    }

    public Course addCourse(Course course) {

        course.setDescription(course.getDescription());
        course.setName(course.getName());
        course.setStartDate(course.getStartDate());
        course.setEndDate(course.getEndDate());
        course.setStudents(course.getStudents());
        course.setSchool(course.getSchool());
        course.setTeacher(course.getTeacher());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.deleteById(id);
        }
        String message = String.format("Course with id %d not found");
        log.info(message);
        throw new NoSuchElementException(message);
    }

    public Course updateCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            Course existingCourse = course.get();
            existingCourse.setName(existingCourse.getName());
            existingCourse.setDescription(existingCourse.getDescription());
            existingCourse.setStartDate(existingCourse.getStartDate());
            existingCourse.setEndDate(existingCourse.getEndDate());
            courseRepository.save(existingCourse);
        }
        String message = String.format("Course with id %d not found", id);
        log.info(message);
        throw new NoSuchElementException(message);
    }
}
