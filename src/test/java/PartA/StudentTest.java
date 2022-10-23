package PartA;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student testStudent;
    private DateTime dob;

    @BeforeEach
    public void init(){
        testStudent = new Student();
        testStudent.setName("Jack");
        dob = new DateTime(2001, 10, 20, 0, 0);
        testStudent.setDob(dob);
    }

    @Test
    public void studentGetUsername() {
        assertNotNull(testStudent.getUsername());
        assertEquals("Jack21", testStudent.getUsername());
    }

    @Test
    public void studentGetId() {
        int low = 1111111;
        int high = 9999999;
        assertNotNull(testStudent.getId());
        assertTrue( high >= testStudent.getId(), "ID too big");
        assertTrue(low  <= testStudent.getId(), "ID too small");
    }

    @Test
    public void studentSetDobString() {
        testStudent.setDob("20/10/2000");
        DateTime dob2 = new DateTime(2000, 10, 20, 0, 0);
        assertNotNull(testStudent.getAge());
        assertEquals(Years.yearsBetween(dob2, DateTime.now()).getYears(), testStudent.getAge());
    }

    @Test
    public void studentGetAge() {
        assertNotNull(testStudent.getAge());
        assertEquals(Years.yearsBetween(dob, DateTime.now()).getYears() ,testStudent.getAge());
    }
}