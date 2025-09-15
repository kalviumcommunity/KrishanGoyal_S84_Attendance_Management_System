package com.school;

public class Student extends Person {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public int getStudentId() {
        return getId();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + this.gradeLevel + ", Role: Student");
    }
}