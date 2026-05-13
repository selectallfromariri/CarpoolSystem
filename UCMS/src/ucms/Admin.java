/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.Scanner;

/**
 *
 * @author yana
 */
public class Admin {
    private String adminID;
    private String adminName;
    private String adminPassword;
    private Scanner sc;

    public Admin(String adminID, String adminName, String adminPassword) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    // approve driver
    public void approveDriver(Driver[] drivers) {
        sc = new Scanner(System.in);

        System.out.println("\n----- APPROVE DRIVER -----");
        System.out.println("Enter Driver ID to approve: ");
        String driverID = sc.nextLine();

        boolean driver = false;
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null && drivers[i].getDriver_id().equalsIgnoreCase(driverID)) {
                System.out.println("\nDriver Details");
                System.out.println("Driver ID      : " + drivers[i].getDriver_id());
                System.out.println("License Number : " + drivers[i].getDriver_license());

                System.out.println("\nApprove this driver? (Y/N): ");
                String approve = sc.nextLine();

                if (approve.equalsIgnoreCase("Y")) {
                    System.out.println("Driver " + drivers[i].getDriver_id() + "has been approved");
                } else {
                    System.out.println("Driver approval cancelled");
                }
                driver = true;
                break;
            }
        }
        if (!driver) {
            System.out.println("Driver not found");
        }
    }

    // view semua driver
    public void viewAllDriver(Driver[] drivers) {
        System.out.println("\nA----- ALL DRIVERS -----");

        boolean driver = false;
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null) {
                System.out.println("\nDriver " + (i + 1));
                System.out.println("Driver ID      : " + drivers[i].getDriver_id());
                System.out.println("License Number : " + drivers[i].getDriver_license());
                System.out.println("Student ID     : " + drivers[i].getStudent_id());
                driver = true;
            }
        }
        if (!driver) {
            System.out.println("No driver found");
        }
    }

    // view feedback
    public void viewFeedback() {
    }

    // view driver report
    public void viewDriverReport(Driver[] drivers) {
        System.out.println("\n----- DRIVER REPORTS -----");
    }

    // admin login
    public boolean loginAdmin(String id, String pass) {
        if (adminID.equalsIgnoreCase(id) && adminPassword.equals(pass)) {
            return true;
        } else {
            return false;
        }

    }
}
