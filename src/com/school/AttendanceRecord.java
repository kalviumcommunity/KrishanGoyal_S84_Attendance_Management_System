package com.school;

public class AttendanceRecord implements Storable {
    private Student student; // Changed from studentId to Student object
    private Course course; // Changed from courseId to Course object
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)
                || "Late".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("  ⚠ Invalid status '" + status + "' - set to 'Invalid'");
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("  " + student.getName() + " → " + course.getCourseName() + " : " + status);
    }

    @Override
    public String toDataString() {
        // Save IDs for simplicity in file storage
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}