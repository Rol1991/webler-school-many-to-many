package hu.webler.weblerschoolmanytomany.controller;


import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public List<Course> renderAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/Id")
    public Course renderCoursesById(Long id) {
        return courseService.findCourseById(id);
    }

    @PostMapping("/courses/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {courseService.deleteCourse(id);}

    @PatchMapping("/courses/update")
    public Course patchCourse(@PathVariable Long id, @RequestBody Course course) {return courseService.updateCourse(id);}

}

