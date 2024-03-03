package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.persistence.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course findCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Writer not found with id: " + id));
    }

    public Course addNewCourse(Course course) {

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
        Course course = findCourseById(id);
        courseRepository.delete(course);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findCourseById(id);
        existingCourse.setName(course.getName());
        return courseRepository.save(existingCourse);
    }
}
