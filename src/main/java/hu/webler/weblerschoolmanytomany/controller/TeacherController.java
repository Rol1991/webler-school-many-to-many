package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/Teacher")
    public List<Teacher> renderAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
