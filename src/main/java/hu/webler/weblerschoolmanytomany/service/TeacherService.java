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

    public Teacher addTeacher(Teacher teacher) {return teacherRepository.save(teacher);}

    public Teacher findTeachersById(Long id) {
        return teacherRepository.findTeachersById(id)
                .orElseThrow(() -> {
                    String message = String.format("Teacher with id %d was not found", id);
                    log.info(message);
                    throw new NoSuchElementException(message);
                });
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

    public Teacher updateTeacher (Long id, Teacher updateTeacher) {
        Teacher teacher = findTeachersById(id);
        teacher.setName(updateTeacher.getName());
        teacher.setCourses(updateTeacher.getCourses());
        return teacherRepository.save(updateTeacher);
    }
}
