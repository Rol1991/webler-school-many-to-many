package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Teacher renderTeacherById(Long id) {return teacherService.getTeacherById(id);}

    @PutMapping("/teachers/add")
    public Teacher addTeacher(Teacher teacher) {return teacherService.addTeacher(teacher);}

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(Long id) {teacherService.deleteTeacher(id);}
}
