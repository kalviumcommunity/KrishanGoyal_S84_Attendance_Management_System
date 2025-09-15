package com.school;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        System.out.println("Creating Students and Courses using Constructors:");
        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Student student2 = new Student("Bob The Builder", "Grade 11");
        Student student3 = new Student("John Doe", "Grade 12");
        Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
        Staff staff1 = new Staff("Mrs. Johnson", "Administrative Assistant");

        Course course1 = new Course("Intro to Programming");
        Course course2 = new Course("Linear Algebra");
        Course course3 = new Course("OOPs");

        System.out.println("\nRegistered Students:");
        student1.displayDetails();
        student2.displayDetails();

        System.out.println("\nTeaching Staff:");
        teacher1.displayDetails();

        System.out.println("\nSupport Staff:");
        staff1.displayDetails();

        System.out.println("\nAvailable Courses:");
        course1.displayDetails();
        course2.displayDetails();

        System.out.println(("\n--- Attendance Record ---"));

        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        AttendanceRecord record1 = new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present");
        attendanceLog.add(record1);

        AttendanceRecord record2 = new AttendanceRecord(student2.getId(), course2.getCourseId(), "Absent");
        attendanceLog.add(record2);

        AttendanceRecord record3 = new AttendanceRecord(student3.getId(), course3.getCourseId(), "Late");
        attendanceLog.add(record3);

        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // File Storage Implementation
        System.out.println("\n--- File Storage Operations ---");

        // Create ArrayLists for each type
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        ArrayList<AttendanceRecord> records = new ArrayList<>(attendanceLog);

        // Create FileStorageService instance and save data
        FileStorageService fileService = new FileStorageService();
        fileService.saveData(students, "students.txt");
        fileService.saveData(courses, "courses.txt");
        fileService.saveData(records, "attendance_log.txt");

    }
}