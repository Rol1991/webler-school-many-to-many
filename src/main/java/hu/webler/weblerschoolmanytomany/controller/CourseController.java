package hu.webler.weblerschoolmanytomany.controller;


import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
import hu.webler.weblerschoolmanytomany.model.CourseModel;
import hu.webler.weblerschoolmanytomany.model.CourseUpdateModel;
import hu.webler.weblerschoolmanytomany.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CourseModel>>  renderAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @GetMapping("/courses/id")
    public ResponseEntity<Course>  renderCourseById(Long id) {
        return ResponseEntity.status(200).body(courseService.findCourseById(id));
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseModel> createCourse(@RequestBody CourseCreateModel courseCreateModel) {
        return ResponseEntity.status(200).body(courseService.createCourse(courseCreateModel));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void>  deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseUpdateModel courseUpdateModel) {
        return ResponseEntity.status(200).body(courseService.updateCourse(id, courseUpdateModel));
    }

}

