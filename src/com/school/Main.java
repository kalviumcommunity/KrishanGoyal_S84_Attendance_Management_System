package com.school;

import java.util.List;

public class Main {

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== School Enrollment & Attendance System ===\n");

        // Create services
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Register students, teachers, staff, and courses
        registrationService.registerStudent("Alice Wonderland", "Grade 10");
        registrationService.registerStudent("Bob The Builder", "Grade 9");
        registrationService.registerTeacher("Dr. Emily Carter", "Physics");
        registrationService.registerStaff("Mr. John Davis", "Librarian");

        // Create courses with capacity
        registrationService.createCourse("Intro to Quantum Physics", 2);
        registrationService.createCourse("Advanced Algorithms", 10);

        System.out.println("--- Courses (Before Enrollment) ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        // Get students and courses for enrollment
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();

        // Enroll students in courses
        System.out.println("\n--- Student Enrollment ---");
        if (students.size() >= 2 && courses.size() >= 2) {
            registrationService.enrollStudentInCourse(students.get(0), courses.get(0)); // Alice in Quantum Physics
            registrationService.enrollStudentInCourse(students.get(1), courses.get(0)); // Bob in Quantum Physics
            registrationService.enrollStudentInCourse(students.get(0), courses.get(1)); // Alice in Algorithms

            // This should fail - course is at capacity
            Student extraStudent = new Student("Charlie Brown", "Grade 11");
            registrationService.enrollStudentInCourse(extraStudent, courses.get(0)); // Should fail - capacity exceeded
        }

        System.out.println("\n--- Courses (After Enrollment) ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        // Mark attendance with enrollment check
        System.out.println("\n--- Marking Attendance ---");
        if (students.size() >= 2 && courses.size() >= 2) {
            Course course1 = courses.get(0);
            Course course2 = courses.get(1);
            Student student1 = students.get(0);
            Student student2 = students.get(1);

            if (course1.getEnrolledStudents().contains(student1)) {
                attendanceService.markAttendance(student1, course1, "Present");
            }

            if (course1.getEnrolledStudents().contains(student2)) {
                attendanceService.markAttendance(student2, course1, "Absent");
            }

            if (course2.getEnrolledStudents().contains(student1)) {
                attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Late");
            }
        }

        // Display attendance logs
        attendanceService.displayAttendanceLog();

        // Save all data
        System.out.println("\n--- Saving Data ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nSystem operations completed successfully.");
    }
}