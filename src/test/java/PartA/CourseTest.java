package PartA;

import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    private Course testCourse;
    private Module testModule;
    private Student testStudent;

    @BeforeEach
    public void init() {
        testCourse = new Course("Electronic & Computer Engineering");
        testCourse.setStartDate(DateTime.now().minusYears(2));
        testCourse.setEndDate(DateTime.now().plusYears(2));
        testModule = new Module("Fake Module", "FM69");
        testStudent = new Student("Tim", "26/03/2001");
    }

    @Test
    public void courseSetDatesString() {
        testCourse.setStartDate("05/09/2019");
        testCourse.setEndDate("05/06/2023");
        assertEquals(3, testCourse.duration());
    }

    @Test
    public void courseDuration() {
        assertEquals(4, testCourse.duration());
    }

    @Test
    public void courseAddRemoveModule() {
        testCourse.addModule(testModule);
        assertEquals(1, testCourse.getModules().size());
        assertEquals(testModule.getName(), testCourse.getModules().get(0).getName());
        assertEquals(1, testModule.getCourses().size());
        assertEquals(testCourse.getName(), testModule.getCourses().get(0).getName());

        testCourse.removeModule(testModule);
        assertEquals(0, testCourse.getModules().size());
        assertEquals(0, testModule.getCourses().size());
    }

    @Test
    public void courseAddRemoveModuleWithStudent() {
        testModule.addStudent(testStudent);
        testCourse.addModule(testModule);
        assertEquals(1, testCourse.getStudents().size());
        assertEquals(1, testStudent.getCourses().size());
        assertEquals(testCourse.getName(), testStudent.getCourses().get(0).getName());

        testCourse.removeModule(testModule);
        assertEquals(0, testStudent.getCourses().size());
    }

}