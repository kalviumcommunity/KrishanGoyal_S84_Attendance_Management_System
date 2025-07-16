package com.school;

public class Main {
    public static void main(String[] args) {

        System.out.println("---School Attendance System---");

        Student[] students = new Student[2];

        Student S1 = new Student();
        Student S2 = new Student();

        S1.setDetails(01, "Krishan");
        S2.setDetails(02, "Harsh");

        students[0] = S1;
        students[1] = S2;

        System.out.println("\nRegistered Students:");

        for (int i = 0; i < students.length; i++) {
            students[i].displayDetails();
        }

        Course[] courses = new Course[2];

        Course C1 = new Course();
        Course C2 = new Course();

        C1.setDetails(01, "Math");
        C2.setDetails(02, "Science");

        courses[0] = C1;
        courses[1] = C2;

        System.out.println("\nAvailable Courses:");

        for (int i = 0; i < courses.length; i++) {
            courses[i].displayDetails();
        }
    }
}