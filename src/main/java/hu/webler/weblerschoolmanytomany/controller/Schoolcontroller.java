package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.persistence.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class Schoolcontroller {

    private final SchoolRepository schoolRepository;

    @GetMapping("/schools")
    public List<School> renderAllSchools() { return schoolRepository.findAll();}
}
