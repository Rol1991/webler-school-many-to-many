package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.findById(id);
        }
        String message = String.format("Student with id %d not found", id);
        log.info(message);
        throw  new NoSuchElementException(message);
    }

    public Student addNewStudent(Student student) {return studentRepository.save(student);}

    public void deleteStudents(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
        }
        String message = String.format("Student with id %d not found", id);
        log.info(message);
        throw new NoSuchElementException(message);
    }

    public Student updateStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student existingStudent = student.get();
            existingStudent.setFirstname(existingStudent.getFirstname());
            existingStudent.setMidName(existingStudent.getMidName());
            existingStudent.setLastName(existingStudent.getLastName());
            studentRepository.save(existingStudent);
        }
        String message = String.format("Student with id %d not found");
        log.info(message);
        throw new NoSuchElementException(message);
    }
}
