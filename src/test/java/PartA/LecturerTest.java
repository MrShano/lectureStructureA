package PartA;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerTest {
    private Lecturer testLecturer;
    private DateTime dob;

    @BeforeEach
    public void init(){
        testLecturer = new Lecturer();
        testLecturer.setName("Peter");
        dob = new DateTime(1965, 9, 20, 0, 0);
        testLecturer.setDob(dob);
    }

    @Test
    public void lecturerSetDobString() {
        testLecturer.setDob("13/09/1955");
        DateTime dob2 = new DateTime(1955, 9, 13, 0, 0);
        assertNotNull(testLecturer.getAge());
        assertEquals(Years.yearsBetween(dob2, DateTime.now()).getYears(), testLecturer.getAge());
    }

    @Test
    public void lecturerGetAge() {
        assertNotNull(testLecturer.getAge());
        assertEquals(Years.yearsBetween(dob, DateTime.now()).getYears() ,testLecturer.getAge());
    }

    @Test
    public void lecturerGetUsername() {
        assertNotNull(testLecturer.getUsername());
        assertEquals("Peter57", testLecturer.getUsername());
    }

    @Test
    public void lecturerGetId() {
        int low = 1111;
        int high = 9999;
        assertNotNull(testLecturer.getId());
        assertTrue( high >= testLecturer.getId(), "ID too big");
        assertTrue(low  <= testLecturer.getId(), "ID too small");
    }
}