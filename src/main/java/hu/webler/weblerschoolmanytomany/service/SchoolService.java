package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.persistence.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public List<School> getSchool() {return schoolRepository.findAll();}

    public School getSchoolById(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()) {
            schoolRepository.findById(id);
        }
        String message = String.format("School with id %d not found", id);
        log.info(message);
        throw new NoSuchElementException(message);
    }

    public School addSchool(School school) {return schoolRepository.save(school);}

    public void deleteSchool(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()) {
            schoolRepository.deleteById(id);
        } else {
            String message = String.format("School with id %d not found", id);
            log.info(message);
            throw new NoSuchElementException(message);
        }
    }

    public School updateSchool(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()) {
            School existingSchool = school.get();
            existingSchool.setName(existingSchool.getName());
            existingSchool.setAddress(existingSchool.getAddress());
            existingSchool.setCourses(existingSchool.getCourses());
            schoolRepository.save(existingSchool);
        }
        String message = String.format("School with id %d not found", id);
        log.info(message);
        throw new NoSuchElementException(message);
    }
}
