package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.StudentCreateModel;
import hu.webler.weblerschoolmanytomany.model.StudentModel;
import hu.webler.weblerschoolmanytomany.model.StudentUpdateModel;
import hu.webler.weblerschoolmanytomany.persistence.StudentRepository;
import hu.webler.weblerschoolmanytomany.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static hu.webler.weblerschoolmanytomany.util.Mapper.mapStudentCreateModelToStudentEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(Mapper::mapStudentEntityToStudentModel)
                .collect(Collectors.toList());
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> {
                    String message = String.format("Student with id %d was not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public StudentModel createStudent(StudentCreateModel studentCreateModel) {
        return Mapper.mapStudentEntityToStudentModel(studentRepository.save(Mapper.mapStudentCreateModelToStudentEntity(studentCreateModel)));
    }

    public void deleteStudents(long id) {
        findStudentById(id);
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, StudentUpdateModel model) {
        Student student = findStudentById(id);
        student.setFirstName(model.getFirstName());
        student.setMidName(model.getMidName());
        student.setLastName(model.getLastName());
        student.setCell(model.getCell());
        student.setEmail(model.getEmail());
        student.setDateOffBirth(model.getDateOffBirth());
        return studentRepository.save(student);
    }
}
