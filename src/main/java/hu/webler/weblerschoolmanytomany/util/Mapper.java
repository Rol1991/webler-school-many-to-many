package hu.webler.weblerschoolmanytomany.util;


import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseModel;

public class Mapper {

    public static CourseModel mapCourseEntityToCourseModel(Course course) {
        CourseModel model = new CourseModel();
        model.setId(course.getId());
        model.setName(course.getName());
        model.setDescription(course.getDescription());
        model.setStartDate(course.getStartDate());
        model.setEndDate(course.getEndDate());
        return model;
    }

    private Mapper() {

    }
}
