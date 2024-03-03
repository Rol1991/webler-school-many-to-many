package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.service.StudentService;
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
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> renderAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/id")
    public Student renderStudentById(Long id) {return studentService.findStudentById(id);}

    @PostMapping("students/{id}")
    public Student postNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @PatchMapping("/students/update")
    public Student patchCourse(@PathVariable Long id,@RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id, @RequestBody Student student) {studentService.deleteStudents(id);}
}
