package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status;

    AttendanceRecord(int studentId, int courseId, String status){
        this.studentId = studentId;
        this.courseId = courseId;

        if("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)){
            this.status = status;
        }
        else{
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status provided. Set to 'Inavlid'.");
        }
    }

    public void displayRecord(){
        System.out.println("Attendance: Student Id" + studentId + " in course Id C" + courseId + " - Status: " + status);
    }
}