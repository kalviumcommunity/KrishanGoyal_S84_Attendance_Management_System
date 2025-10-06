package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System (Polymorphism Demo) ---");

        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Student student2 = new Student("Bob The Builder", "Grade 9");
        Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
        Staff staff1 = new Staff("Mr. John Davis", "Librarian");

        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(student1);
        schoolPeople.add(student2);
        schoolPeople.add(teacher1);
        schoolPeople.add(staff1);

        displaySchoolDirectory(schoolPeople);

        Course course1 = new Course("Intro to Quantum Physics");
        Course course2 = new Course("Advanced Algorithms");
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        System.out.println("\n\n--- Available Courses ---");
        for (Course c : courses)
            c.displayDetails();

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(student1);
        allStudents.add(student2);

        List<Course> allCourses = new ArrayList<>();
        allCourses.add(course1);
        allCourses.add(course2);

        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course1, "Absent");

        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Daydreaming", allStudents,
                allCourses);

        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(student1);
        attendanceService.displayAttendanceLog(course1);

        System.out.println("\n\n--- Saving Data to Files ---");
        List<Student> studentsToSave = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentsToSave.add((Student) p);
            }
        }
        if (!studentsToSave.isEmpty()) {
            storageService.saveData(studentsToSave, "students.txt");
        } else {
            System.out.println("No student data to save from school directory.");
        }

        storageService.saveData(courses, "courses.txt");
        attendanceService.saveAttendanceData();
    }
}