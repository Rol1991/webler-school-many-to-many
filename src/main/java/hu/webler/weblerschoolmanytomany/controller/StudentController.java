package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> renderAllStudents() {
        return studentService.getAllStudents();
    }
}
