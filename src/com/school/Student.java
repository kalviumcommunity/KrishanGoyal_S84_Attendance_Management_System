package com.school;

class Student {
    int studentId;
    String studentName;

    public void setDetails(int studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public void displayDetails(){
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.studentName);
    }
}
