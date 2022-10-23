package PartA;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;

public class Course {

    private String name;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Module> modules = new ArrayList<Module>();
    private DateTime startDate;
    private DateTime endDate;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, ArrayList<Student> students, ArrayList<Module> modules) {
        this(name);
        this.students = students;
        this.modules = modules;
    }

    public Course(String name, ArrayList<Student> students, ArrayList<Module> modules, DateTime startDate, DateTime endDate) {
        this(name, students, modules);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Course(String name, ArrayList<Student> students, ArrayList<Module> modules, String startDate, String endDate) {
        this(name, students, modules);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public DateTime stringToDate(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern("dd/mm/yyyy"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = stringToDate(startDate);
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = stringToDate(endDate);
    }

    public Integer duration() {
        return Years.yearsBetween(startDate, endDate).getYears();
    }

    public void addModule(Module module) {
        modules.add(module);

        for (Student student : module.getStudents()) {
            student.addCourse(this);
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        module.addCourse(this);
    }

    public void removeModule(Module module) {
        modules.remove(module);

        for (Student student : module.getStudents()) {
            student.removeCourse(this);
            students.remove(student);
        }

        module.removeCourse(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n" + "Course Name: ").append(name);
        str.append("\n" + "  Start Date: ").append(startDate.toLocalDate().toString());
        str.append("\n" + "  End Date: ").append(endDate.toLocalDate().toString());
        str.append("\n" + "  Modules: ");
        for (Module module : modules) {
            str.append("\n" + "   - ").append(module.getName()).append("(").append(module.getId()).append(")");
        }
        str.append("\n" + "  Students: ");
        for (Student student : students) {
            str.append("\n" + "   - ").append(student.getName());
        }
        return str.toString();
    }
}