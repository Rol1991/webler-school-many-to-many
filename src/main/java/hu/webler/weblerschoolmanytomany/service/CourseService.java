package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
import hu.webler.weblerschoolmanytomany.model.CourseModel;
import hu.webler.weblerschoolmanytomany.persistence.CourseRepository;
import hu.webler.weblerschoolmanytomany.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;


    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(Mapper::mapCourseEntityToCourseModel)
                .collect(Collectors.toList());
    }

    public Course findCourseById(Long id) {
        return courseRepository.findCourseById(id)
                .orElseThrow(() -> {
                String message = String.format("Course with id %d not found", id);
                        log.info(message);
                        return new NoSuchElementException(message);
                });
    }

    public CourseModel createCourse(CourseCreateModel courseCreateModel) {
        return Mapper.mapCourseEntityToCourseModel(courseRepository.save(Mapper.mapCourseCreateModelTCourseEntity(courseCreateModel)));
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

    public Course updateCourse(Long id, Course updateCourse) {
        Course course = findCourseById(id);
        course.setName(updateCourse.getName());
        course.setDescription(updateCourse.getDescription());
        course.setStartDate(updateCourse.getStartDate());
        course.setEndDate(updateCourse.getEndDate());
        return courseRepository.save(updateCourse);
        }

}
