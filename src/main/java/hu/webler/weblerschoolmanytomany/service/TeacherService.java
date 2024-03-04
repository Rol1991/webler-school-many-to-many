package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.persistence.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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

    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            teacherRepository.findById(id);
        }
        String message = String.format("Teacher with id %d not found");
        log.info(message);
        throw new NoSuchElementException(message);
    }


    public void deleteTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            teacherRepository.deleteById(id);
        } else {
            String message = String.format("Teacher with id %d not found", id);
            log.info(message);
            throw new NoSuchElementException(message);
        }
    }
}
