package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.TeacherCreateModel;
import hu.webler.weblerschoolmanytomany.model.TeacherModel;
import hu.webler.weblerschoolmanytomany.model.TeacherUpdateModel;
import hu.webler.weblerschoolmanytomany.persistence.TeacherRepository;
import hu.webler.weblerschoolmanytomany.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherModel> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(Mapper::mapTeacherEntityToTeacherModel)
                .collect(Collectors.toList());
    }

    public TeacherModel addTeacher(TeacherCreateModel teacherCreateModel) {
        return Mapper.mapTeacherEntityToTeacherModel(teacherRepository.save(Mapper.mapTeacherCreateModelToTeacherEntity(teacherCreateModel)));
        }

    public Teacher findTeacherById(Long id) {
        return teacherRepository.findTeacherById(id)
                .orElseThrow(() -> {
                    String message = String.format("Teacher with id %d was not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public void deleteTeacher(Long id) {
        findTeacherById(id);
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher (Long id, TeacherUpdateModel teacherUpdateModel) {
        Teacher teacher = findTeacherById(id);
        teacher.setName(teacherUpdateModel.getName());
        teacher.setCourses(teacherUpdateModel.getCourses());
        return teacherRepository.save(teacher);
    }
}
