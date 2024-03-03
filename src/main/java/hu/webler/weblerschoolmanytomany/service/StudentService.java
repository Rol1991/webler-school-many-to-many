package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {return studentRepository.findStudentById(id);}

    public Student addNewStudent(Student student) {return studentRepository.save(student);}

    public void deleteStudents(long id) {
        Student existingStudent = studentRepository.findStudentById(id);
        studentRepository.delete(existingStudent);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findStudentById(id);
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setLastName(student.getMidName());
        return studentRepository.save(existingStudent);

    }
}
