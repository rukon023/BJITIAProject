package com.example.bjitiaproject.model;

public class Student {
    private String userName;
    private String email;
    private String password;
    private String phoneNo;
    private Float cgpa;

    public Student() {
    }

    public Student(String userName, String email, String password, String phoneNo, Float cgpa) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.cgpa = cgpa;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
