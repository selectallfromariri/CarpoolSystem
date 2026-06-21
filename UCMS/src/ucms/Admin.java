/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;
import java.util.ArrayList;
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
    public static void approveDriver(ArrayList<Driver> drivers, ArrayList<String> PemanduApproved) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n----- APPROVE DRIVER -----");       
           if (drivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }
        // display semua drivers
        System.out.println("\nList of Drivers:");
            for (Driver d : drivers) {
                if (d != null) {
                    System.out.println("--------------------------------");
                    System.out.println("Driver ID      : "+ d.getDriver_id());
                    System.out.println("Driver Name    : " + d.getStudent_name());
                    System.out.println("License Number : " + d.getDriver_license());
                }
            }
    
        System.out.println("Enter Driver ID to approve: ");
        String driverID = sc.nextLine();

        boolean driver = false;
        for (Driver d : drivers) {
            if (d != null && d.getDriver_id().equalsIgnoreCase(driverID)) {
                System.out.println("\nDriver Details");
                System.out.println("Driver ID      : " + d.getDriver_id());
                System.out.println("License Number : " + d.getDriver_license());

                System.out.println("\nApprove this driver? (Y/N): ");
                String approve = sc.nextLine();

                if (approve.equalsIgnoreCase("Y")) {
                    PemanduApproved.add(d.getDriver_id());
                    System.out.println("Driver " + d.getDriver_id() + " has been approved");
                    d.setApproved(true);
                } 
                else {
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
    public static void viewAllDriver(ArrayList<Driver> drivers) {
        System.out.println("\n----- ALL DRIVERS -----");

        boolean driver = false;
        int count = 1;
        for (Driver d : drivers) {
            if (d != null) {
                System.out.println("\nDriver " + (count));
                System.out.println("Student ID     : " + d.getStudent_id());
                System.out.println("Driver ID      : " + d.getDriver_id());
                System.out.println("Driver Name    : "+ d.getStudent_name());
                System.out.println("Driver Num Tel : "+ d.getPhone_num());
                System.out.println("License Number : " + d.getDriver_license());
                
                driver = true;
            }
        }
        if (!driver) {
            System.out.println("No driver found");
        }
    }

    // view feedback
    public static void viewFeedback(ArrayList<Feedback> feeds){
        System.out.println("\n----- FEEDBACKS FROM PASSENGER -----");        
            if (feeds.isEmpty()) {
            System.out.println("No feedbacks recorded in the system.");
            return;
        }

        for (int i = 0; i < feeds.size(); i++) {
            System.out.println("\nFEEDBACK " + (i + 1));
            feeds.get(i).displayFeedback();
    }
}
    
    // view driver report
    /**
    public static void viewDriverReport(ArrayList<Driver> drivers) {
        System.out.println("\n----- DRIVER REPORTS -----");
        
        if (drivers.isEmpty()){
            System.out.println("No drivers in the recorded in the system.");
            return;
        }
        
        System.out.println("\nDriver Reports Summary");
            int count = 1;
            for (Driver d : drivers) {
                if (d != null) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Driver ID    : " + d.getDriver_id());
                    System.out.println("License Number : " + d.getDriver_license());
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Reports : " + );
                    count++;
                }
            }
    }        
    */

    // admin login
    public boolean loginAdmin(String id, String pass) {
        if (adminID.equalsIgnoreCase(id) && adminPassword.equals(pass)) {
            System.out.println("\nAdmin login successful!");
            System.out.println("Welcome:" + adminName + "!");
            return true;
        } else {
            System.out.println("\nInvalid Admin ID or Password!");
            return false;
        }
    }
}
