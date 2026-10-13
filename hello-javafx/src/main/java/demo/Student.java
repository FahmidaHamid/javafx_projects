package demo;

public class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " | ID: " + id + " | GPA: " + gpa;
    }
}