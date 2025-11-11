package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;

    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("Cannot add null student.");
            return false;
        }
        if (enrolledStudents.size() >= capacity) {
            System.out.println("Cannot add student: Course is at full capacity.");
            return false;
        }
        if (enrolledStudents.contains(student)) {
            System.out.println("Student " + student.getName() + " is already enrolled in this course.");
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + this.courseId + ", Name: " + this.courseName +
                ", Capacity: " + this.capacity +
                ", Enrolled: " + this.enrolledStudents.size() + "/" + this.capacity);
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName + "," + capacity;
    }
}