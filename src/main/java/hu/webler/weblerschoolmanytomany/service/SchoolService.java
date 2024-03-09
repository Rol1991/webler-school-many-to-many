package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
import hu.webler.weblerschoolmanytomany.model.SchoolUpdateModel;
import hu.webler.weblerschoolmanytomany.persistence.SchoolRepository;
import hu.webler.weblerschoolmanytomany.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public List<SchoolModel> getSchool() {
        return schoolRepository.findAll()
                .stream()
                .map(Mapper::mapSchoolEntityToSchoolModel)
                .collect(Collectors.toList());
        }

    public School findSchoolById(Long id) {
        return schoolRepository.findSchoolById(id)
                .orElseThrow(() -> {
                    String message = String.format("School with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public SchoolModel createSchool(SchoolCreateModel schoolCreateModel) {
        return Mapper.mapSchoolEntityToSchoolModel(schoolRepository.save(Mapper.mapSchoolCreateModelToSchoolEntity(schoolCreateModel)));
    }


    public void deleteSchool(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()) {
            schoolRepository.deleteById(id);
        } else {
            String message = String.format("School with id %d not found", id);
            log.info(message);
            throw  new NoSuchElementException(message);
        }
    }

    public School updateSchool(Long id, SchoolUpdateModel model) {
        School school = findSchoolById(id);
        school.setName(model.getName());
        school.setAddress(model.getAddress());
        school.setCourses(model.getCourses());
        return schoolRepository.save(school);
    }
}
