package PartA;

import java.util.ArrayList;

public class Module {
    private String name;
    private String id;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Module() {
    }

    public Module(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Module(String name, String id, ArrayList<Student> students, ArrayList<Lecturer> lecturers, ArrayList<Course> courses) {
        this(name, id);
        this.students = students;
        this.lecturers = lecturers;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        student.addModule(this);
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        student.removeModule(this);
        students.remove(student);
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void addLecturer(Lecturer lecturer) {
        lecturer.addModule(this);
        if (!lecturers.contains(lecturer)) {
            lecturers.add(lecturer);
        }
    }

    public void removeLecturer(Lecturer lecturer) {
        lecturer.removeModule(this);
        lecturers.remove(lecturer);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    void removeCourse(Course course) {
        courses.remove(course);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n" + "Module Name: ").append(name);
        str.append("\n" + "  Id: ").append(id);
        str.append("\n" + "  Courses: ");
        for (Course course : courses) {
            str.append("\n" + "   - ").append(course.getName());
        }
        str.append("\n" + "  Students: ");
        for (Student student : students) {
            str.append("\n" + "   - ").append(student.getName());
        }
        str.append("\n" + "  Lecturers: ");
        for (Lecturer lecturer : lecturers) {
            str.append("\n" + "   - ").append(lecturer.getName());
        }
        return str.toString();
    }
}