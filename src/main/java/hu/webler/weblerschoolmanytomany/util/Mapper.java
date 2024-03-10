package hu.webler.weblerschoolmanytomany.util;


import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
import hu.webler.weblerschoolmanytomany.model.CourseModel;
import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
import hu.webler.weblerschoolmanytomany.model.StudentCreateModel;
import hu.webler.weblerschoolmanytomany.model.StudentModel;
import hu.webler.weblerschoolmanytomany.model.TeacherCreateModel;
import hu.webler.weblerschoolmanytomany.model.TeacherModel;

public class Mapper {

    public static CourseModel mapCourseEntityToCourseModel(Course course) {
        CourseModel model = new CourseModel();
        model.setId(course.getId());
        model.setName(course.getName());
        model.setDescription(course.getDescription());
        model.setStartDate(course.getStartDate());
        model.setEndDate(course.getEndDate());
        model.setSchool(course.getSchool());
        model.setTeacher(course.getTeacher());
        return model;
    }

    public static Course mapCourseCreateModelToCourseEntity(CourseCreateModel model) {
        Course currentCourse = new Course();
        currentCourse.setName(model.getName());
        currentCourse.setDescription(model.getDescription());
        currentCourse.setStartDate(model.getStartDate());
        currentCourse.setEndDate(model.getEndDate());
        return currentCourse;
    }

    public static StudentModel mapStudentEntityToStudentModel (Student student) {
        StudentModel model = new StudentModel();
        model.setId(student.getId());
        model.setFirstName(student.getFirstName());
        model.setMidName(student.getMidName());
        model.setLastName(student.getLastName());
        model.setEmail(student.getEmail());
        model.setCell(student.getCell());
        return model;
    }

    public static Student mapStudentCreateModelToStudentEntity(StudentCreateModel model) {
        Student student = new Student();
        student.setFirstName(model.getFirstName());
        student.setMidName(model.getMidName());
        student.setLastName(model.getLastName());
        student.setEmail(model.getEmail());
        student.setCell(model.getCell());
        student.setDateOffBirth(model.getDateOffBirth());
        return student;
    }



    public static TeacherModel  mapTeacherEntityToTeacherModel(Teacher teacher) {
        TeacherModel model = new TeacherModel();
        model.setId(teacher.getId());
        model.setName(teacher.getName());
        model.setCourses(teacher.getCourses());
        return model;
    }

    public static Teacher mapTeacherCreateModelToTeacherEntity(TeacherCreateModel model) {
        Teacher teacher = new Teacher();
        teacher.setName(model.getName());
        teacher.setCourses(model.getCourses());
        return teacher;
    }

    public static SchoolModel mapSchoolEntityToSchoolModel(School school) {
        SchoolModel model = new SchoolModel();
        model.setId(school.getId());
        model.setName(school.getName());
        model.setAddress(school.getAddress());
        model.setCourses(school.getCourses());
        return model;
    }

    public static School mapSchoolCreateModelToSchoolEntity(SchoolCreateModel model) {
        School school = new School();
        school.setName(model.getName());
        school.setAddress(model.getAddress());
        return school;
    }

    private Mapper() {

    }
}
