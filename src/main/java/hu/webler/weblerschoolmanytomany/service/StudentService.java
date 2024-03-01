package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
