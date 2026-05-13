/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

/**
 *
 * @author USER
 */
public class Feedback {
    private String feedbackID;
    private String comment;
    private Student student;
    private Driver driver;

    public Feedback(String feedbackID, String comment, Student student, Driver driver) {
        this.feedbackID = "FDB" + feedbackID;
        this.comment = comment;
        this.student = student;
        this.driver = driver;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String submitFeedback() {
        return "Feedback submitted successfully!";
    }

    public void displayFeedback() {
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("Student: " + student.getStudent_name());
        System.out.println("Driver: " + driver.getStudent_name());
        System.out.println("Comment: " + comment);
    }
}