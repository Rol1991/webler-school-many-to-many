package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.persistence.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        teacher.setFirstname((teacher.getFirstname()));
        teacher.setMidName(teacher.getMidName());
        teacher.setLastName(teacher.getLastName());
        teacher.setCell(teacher.getCell());
        teacher.setEmail(teacher.getEmail());
        teacher.setDateOffBirth(teacher.getDateOffBirth());
        teacher.setName(teacher.getName());
        teacher.setCourses(teacher.getCourses());
        return teacherRepository.save(teacher);}

    public Optional<Teacher> getTeacherById(Long id) {return teacherRepository.findById(id);}

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepository.getTeacherById(id);
        existingTeacher.setName(teacher.getName());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.getTeacherById(id);
        teacherRepository.delete(teacher);
    }
}
