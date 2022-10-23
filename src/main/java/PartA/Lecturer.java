package PartA;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;

public class Lecturer {
    private String name;
    private DateTime dob;
    private Integer id;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<Course> courses = new ArrayList<Course>();

    private final int min = 1111;
    private final int max = 9999;

    public Lecturer(String name, String dob) {
        this();
        this.name = name;
        setDob(dob);
    }

    public Lecturer(String name, DateTime dob) {
        this();
        this.name = name;
        this.dob = dob;
    }

    public Lecturer(String name, DateTime dob, ArrayList<Module> modules, ArrayList<Course> courses) {
        this(name, dob);
        this.modules = modules;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public void setDob(String dob) {
        this.dob = DateTime.parse(dob, DateTimeFormat.forPattern("dd/mm/yyyy"));
    }

    public String getUsername() {
        return name + getAge();
    }

    public Integer getAge() {
        if (dob != null) {
            return Years.yearsBetween(dob, DateTime.now()).getYears();
        }
        return null;
    }

    Lecturer() {
        this.id = min + (int) (Math.random() * ((max - min)) + 1);
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    void addModule(Module module) {
        modules.add(module);
    }

    void removeModule(Module module) {
        modules.remove(module);
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
        str.append("\n" + "Lecturer Name: ").append(name);
        str.append("\n" + "  Lecturer ID: ").append(id);
        str.append("\n" + "  Lecturer DOB: ").append(dob.toLocalDate().toString());
        str.append("\n" + "  Courses: ");
        for (Course course : courses) {
            str.append("\n" + "   - ").append(course.getName());
        }
        str.append("\n" + "  Modules: ");
        for (Module module : modules) {
            str.append("\n" + "   - ").append(module.getName()).append("(").append(module.getId()).append(")");
        }
        return str.toString();
    }
}
