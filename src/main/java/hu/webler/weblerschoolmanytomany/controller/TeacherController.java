package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.TeacherCreateModel;
import hu.webler.weblerschoolmanytomany.model.TeacherModel;
import hu.webler.weblerschoolmanytomany.model.TeacherUpdateModel;
import hu.webler.weblerschoolmanytomany.service.TeacherService;
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
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherModel>> renderAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherModel> createTeachers(@RequestBody TeacherCreateModel teacherCreateModel) {
        return ResponseEntity.status(200).body(teacherService.addTeacher(teacherCreateModel));
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id) {teacherService.deleteTeacher(id);}

    @PatchMapping("/teachers/{id}")
    public Teacher patchTeacher(@PathVariable Long id, @RequestBody TeacherUpdateModel teacherUpdateModel) {return teacherService.updateTeacher(id, teacherUpdateModel);}
}
