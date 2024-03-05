package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> renderAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PutMapping("/teachers")
    public Teacher postTeacher(@RequestBody Teacher teacher) {return teacherService.addTeacher(teacher);}

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id) {teacherService.deleteTeacher(id);}

    @PatchMapping("/teachers/{id}")
    public Teacher patchTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {return teacherService.updateTeacher(id, teacher);}
}
