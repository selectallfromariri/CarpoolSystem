/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

public class Report {

    private String reportID;
    private Driver driver;
    private String type;
    private String details;

    public Report(String reportID,Driver driver,String type,String details) {
        this.reportID = "RPT" + reportID;
        this.driver = driver;
        this.type = type;
        this.details = details;
    }

    public String getReportID() {
        return reportID;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }

    public void displayReport() {

        System.out.println("Report ID   : " + reportID);
        System.out.println("Driver Name : "+ driver.getStudent_name());
        System.out.println("Driver ID   : "+ driver.getStudent_id());
        System.out.println("Type        : " + type);
        System.out.println("Details     : " + details);
        System.out.println("-----------------------------------");
    }
}
