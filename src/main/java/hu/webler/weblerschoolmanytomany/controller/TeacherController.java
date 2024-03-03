package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/Teachers")
    public List<Teacher> renderAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers")
    public Optional<Teacher> renderTeacherById(Long id) {return teacherService.getTeacherById(id);}

    @PutMapping("/teachers/add")
    public Teacher addTeacher(Teacher teacher) {return teacherService.addTeacher(teacher);}

    @PostMapping("/teacher/update")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {return teacherService.updateTeacher(id, teacher);}
    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(Long id) {teacherService.deleteTeacher(id);}
}
