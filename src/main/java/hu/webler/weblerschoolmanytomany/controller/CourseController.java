package hu.webler.weblerschoolmanytomany.controller;


import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/courses/add")
    public Object postNewCourses(@RequestBody Course course) {
        return courseService.addNewCourse(course);
    }
}

