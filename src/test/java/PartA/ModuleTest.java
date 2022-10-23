package PartA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleTest {
    private Module testModule;

    @BeforeEach
    public void init() {
        testModule = new Module();
        testModule.setName("System on chip");
        testModule.setId("soc1");
    }

    @Test
    public void moduleAddRemoveCourse() {
        Course testCourse = new Course("Electronic & Computer Engineering");

        testModule.addCourse(testCourse);
        assertEquals(1, testModule.getCourses().size());
        assertEquals("Electronic & Computer Engineering", testModule.getCourses().get(0).getName());

        testModule.removeCourse(testCourse);
        assertEquals(0, testModule.getCourses().size());
    }

    @Test
    public void moduleAddRemoveStudent() {
        Student testStudent = new Student();

        testModule.addStudent(testStudent);
        assertEquals(1, testModule.getStudents().size());
        assertEquals(testStudent.getId(), testModule.getStudents().get(0).getId());
        assertEquals(1, testStudent.getModules().size());
        assertEquals(testModule.getName(), testStudent.getModules().get(0).getName());

        testModule.removeStudent(testStudent);
        assertEquals(0, testModule.getStudents().size());
        assertEquals(0, testStudent.getModules().size());
    }
}