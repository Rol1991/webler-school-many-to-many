package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/schools")
    public List<School> renderSchool() {
        return schoolService.getSchool();
    }

    @PostMapping("/schools")
    public School addSchool(@RequestBody School school) {return schoolService.addSchool(school);}

    @DeleteMapping("/schools/{id}")
    public void deleteSchool(@PathVariable Long id) { schoolService.deleteSchool(id);}

    @PatchMapping("/schools/{id}")
    public School patchSchool(@PathVariable Long id, @RequestBody School school) {return schoolService.updateSchool(id, school);}
}
