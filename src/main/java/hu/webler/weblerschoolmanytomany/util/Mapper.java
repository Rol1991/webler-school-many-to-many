package hu.webler.weblerschoolmanytomany.util;


import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
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

    public static Course mapCourseCreateModelTCourseEntity(CourseCreateModel model) {
        Course currentCourse = new Course();
        currentCourse.setName(model.getName());
        currentCourse.setDescription(model.getDescription());
        currentCourse.setStartDate(model.getStartDate());
        currentCourse.setEndDate(model.getEndDate());
        return currentCourse;
    }

    private Mapper() {

    }
}
