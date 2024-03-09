package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
import hu.webler.weblerschoolmanytomany.model.SchoolUpdateModel;
import hu.webler.weblerschoolmanytomany.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<SchoolModel>> renderAllSchools() {
        return ResponseEntity.status(200).body(schoolService.getSchool());
    }

    @PostMapping("/schools")
    public ResponseEntity<SchoolModel> createSchool(@RequestBody SchoolCreateModel schoolCreateModel) {
        return ResponseEntity.status(200).body(schoolService.createSchool(schoolCreateModel));
    }

    @DeleteMapping("/schools/{id}")
    public void deleteSchool(@PathVariable Long id) { schoolService.deleteSchool(id);}

    @PatchMapping("/schools/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody SchoolUpdateModel schoolUpdateModel) {
        return ResponseEntity.status(200).body(schoolService.updateSchool(id, schoolUpdateModel));
    }
}
