package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.model.StudentCreateModel;
import hu.webler.weblerschoolmanytomany.model.StudentModel;
import hu.webler.weblerschoolmanytomany.model.StudentUpdateModel;
import hu.webler.weblerschoolmanytomany.service.StudentService;
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
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentModel>> renderAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

   @PostMapping("/students")
   public ResponseEntity<StudentModel> createStudents(@RequestBody StudentCreateModel studentCreateModel) {
        return ResponseEntity.status(200).body(studentService.createStudent(studentCreateModel));
   }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudents(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/students/{id}")
    public Student patchStudent(@PathVariable Long id, @RequestBody StudentUpdateModel student) {return studentService.updateStudent(id, student);}
}
