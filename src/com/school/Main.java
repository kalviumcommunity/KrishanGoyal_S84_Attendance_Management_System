package com.school; 
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        System.out.println("Creating Students and Courses using Constructors:");
        Student student1 = new Student("Alice Wonderland");
        Student student2 = new Student("Bob The Builder");
        Student student3 = new Student("John Doe");

        Course course1 = new Course("Intro to Programming");
        Course course2 = new Course("Linear Algebra");
        Course course3 = new Course("OOPs");

        System.out.println("\nRegistered Students:");
        student1.displayDetails();
        student2.displayDetails();

        System.out.println("\nAvailable Courses:");
        course1.displayDetails();
        course2.displayDetails();

        System.out.println(("\n--- Attendance Record ---"));

        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        AttendanceRecord record1 = new AttendanceRecord(student1.getStudentId(), course1.getCourseId(), "Present");
        attendanceLog.add(record1);

        AttendanceRecord record2 = new AttendanceRecord(student2.getStudentId(), course2.getCourseId(), "Absent");
        attendanceLog.add(record2);

        AttendanceRecord record3 = new AttendanceRecord(student3.getStudentId(), course3.getCourseId(), "Late");
        attendanceLog.add(record3);

        for (AttendanceRecord record: attendanceLog){
            record.displayRecord();
        }

        // System.out.println("\n== Auto-ID Generation Test ==");
        // System.out.println("Creating one more student and course...");
        // Student student3 = new Student("Charlie Chaplin");
        // Course course3 = new Course("Data Structures");

        // System.out.println("\nNew Student:");
        // student3.displayDetails();

        // System.out.println("New Course:");
        // course3.displayDetails();

        // System.out.println("\nSession 3: Constructor Initialization & Auto-ID Generation Complete.");


    }
}