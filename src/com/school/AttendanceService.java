package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // Overload 1: mark using objects
    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) {
            System.out.println("Cannot mark attendance: student or course is null.");
            return;
        }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Overload 2: mark using ids, plus lookup lists
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents,
            List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found. Skipping attendance.");
            return;
        }
        if (course == null) {
            System.out.println("Course with ID " + courseId + " not found. Skipping attendance.");
            return;
        }

        markAttendance(student, course, status);
    }

    // Helper finders
    private Student findStudentById(int id, List<Student> allStudents) {
        if (allStudents == null)
            return null;
        for (Student s : allStudents) {
            if (s != null && s.getId() == id)
                return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        if (allCourses == null)
            return null;
        for (Course c : allCourses) {
            if (c != null && c.getCourseId() == id)
                return c;
        }
        return null;
    }

    // Display methods
    public void displayAttendanceLog() {
        System.out.println("\n\n--- Attendance Log ---");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records yet.");
            return;
        }
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println(
                "\n\n--- Attendance Log for Student: " + (student != null ? student.getName() : "<null>") + " ---");
        if (student == null) {
            System.out.println("No student provided.");
            return;
        }
        boolean any = false;
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getStudent().getId() == student.getId()) {
                ar.displayRecord();
                any = true;
            }
        }
        if (!any)
            System.out.println("No records for this student.");
    }

    public void displayAttendanceLog(Course course) {
        System.out.println(
                "\n\n--- Attendance Log for Course: " + (course != null ? course.getCourseName() : "<null>") + " ---");
        if (course == null) {
            System.out.println("No course provided.");
            return;
        }
        boolean any = false;
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getCourse().getCourseId() == course.getCourseId()) {
                ar.displayRecord();
                any = true;
            }
        }
        if (!any)
            System.out.println("No records for this course.");
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}