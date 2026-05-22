/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ucms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author harir
 */
public class UCMS {

    private Scanner sc;

    public UCMS() {
        sc = new Scanner(System.in);
    }

    private ArrayList<Passenger> penumpang = new ArrayList<>();
    private ArrayList<Driver> Pemandu = new ArrayList<>();
    private ArrayList<Admin> Ketua = new ArrayList<>();
    private ArrayList<Student> Pelajar = new ArrayList<>();
    private ArrayList<Carpool> carpools = new ArrayList<>();
    private ArrayList<booking> bookings = new ArrayList<>();
    private ArrayList<Report> reports = new ArrayList<>();
    private ArrayList<Feedback> feeds = new ArrayList<>();
    private ArrayList<String> PemanduApproved = new ArrayList<>();

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        System.out.println("================================================================================");
        System.out.println("   /$$          /$$   /$$ /$$      /$$ /$$$$$$$                              \n"
                + "  | $$         | $$  | $$| $$$    /$$$| $$__  $$                             \n"
                + " /$$$$$$       | $$  | $$| $$$$  /$$$$| $$  \\ $$ /$$$$$$  /$$$$$$$   /$$$$$$ \n"
                + "|_  $$_//$$$$$$| $$  | $$| $$ $$/$$ $$| $$$$$$$/|____  $$| $$__  $$ /$$__  $$\n"
                + "  | $$ |______/| $$  | $$| $$  $$$| $$| $$____/  /$$$$$$$| $$  \\ $$| $$  \\ $$\n"
                + "  | $$ /$$     | $$  | $$| $$\\  $ | $$| $$      /$$__  $$| $$  | $$| $$  | $$\n"
                + "  |  $$$$/     |  $$$$$$/| $$ \\/  | $$| $$     |  $$$$$$$| $$  | $$|  $$$$$$$\n"
                + "   \\___/        \\______/ |__/     |__/|__/      \\_______/|__/  |__/ \\____  $$\n"
                + "                                                                    /$$  \\ $$\n"
                + "                                                                   |  $$$$$$/\n"
                + "                                                                    \\______/ ");
       
        UCMS app = new UCMS();
        Admin admin1 = new Admin("admin1", "Kiwi","admin123");
        app.Ketua.add(admin1);
        while (true) {
            app.menu();
        }
    }

    // first menu
    public void menu() {
        System.out.println("================================================================================");
        System.out.println("|                               1)Register                                     |");
        System.out.println("|                           2)Login as Student                                 |");
        System.out.println("|                            3)Login as Admin                                  |");
        System.out.println("|                                  4)Exit                                      |");
        System.out.println("================================================================================");

        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.skip("\\R?");

        if (choice == 1) {
            registerMenu();
        } else if (choice == 2) {
            studentlogin();
        }
        else if (choice == 3){
            adminLogin();
        }
        else if (choice == 4) {
            System.out.println("Goodbye!");
            System.exit(0);
        }

    }

    // register menu
    public void registerMenu() {
        System.out.println("");
        System.out.println("================================================================================");
        System.out.println("                  t-UMPang:UMPSA Campus Carpool Management System               ");
        System.out.println("================================================================================");
        System.out.println("|                                 1)Register  as Driver                        |");
        System.out.println("|                                2)Register as Passenger                       |");
        System.out.println("|                                          3)Exit                              |");
        System.out.println("================================================================================");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.skip("\\R?");
        if (choice == 1) {
            registerDriver();
        } else if (choice == 2) {
            registerPassenger();
        }
        else if (choice == 3) {
            return;
        }

    }
    
    // driver register
    public void registerDriver() {
        System.out.println("\n-----Register Driver-----");
        System.out.print("Enter your Student ID: ");
        String id = sc.nextLine();

        for (Driver d : Pemandu) {
            if (d.getStudent_id().equalsIgnoreCase(id)) {
                System.out.println("[WARNING] Student ID already registered. Please login instead.");
                return;
            }
        }
        System.out.print("Full Name    : ");
        String name = sc.nextLine();
        System.out.print("Phone Number : ");
        String notel = sc.nextLine();
        System.out.print("Password     : ");
        String pass = sc.nextLine();
        System.out.print("Confirm Pass : ");
        String cpass = sc.nextLine();

        if (!pass.equals(cpass)) {
            System.out.println("[!] Passwords do not match. Please try again.");
            return;
        }

        System.out.println("\n  -- Vehicle & License Info --");
        System.out.print("License No.   : ");
        String lic = sc.nextLine();
        System.out.print("Car Plate No. : ");
        String plate = sc.nextLine();
        System.out.print("Car Model     : ");
        String model = sc.nextLine();
        System.out.print("Car Color     : ");
        String color = sc.nextLine();

        String driverID = String.format("%02d", Pemandu.size() + 1);
        Driver pemandubaru = new Driver(driverID, lic, id, name, notel, pass, plate, model, color);
        Pemandu.add(pemandubaru);

        System.out.println("\nDriver Registered Successfully!");

        pemandubaru.displayProfile();

    }

    // passenger register
    public void registerPassenger() {
        System.out.println("\n-----Register Passenger-----");
        System.out.print("Enter your Student ID: ");
        String id = sc.nextLine();
        for (Passenger p : penumpang) {
            if (p.getStudent_id().equalsIgnoreCase(id)) {
                System.out.println("[WARNING] Student ID already registered. Please login instead.");
                return;
            }
        }
        System.out.print("Full Name    : ");
        String name = sc.nextLine();
        System.out.print("Phone Number : ");
        String notel = sc.nextLine();
        System.out.print("Password     : ");
        String pass = sc.nextLine();
        System.out.print("Confirm Pass : ");
        String cpass = sc.nextLine();
        if (!pass.equals(cpass)) {
            System.out.println("[WARNING] Passwords do not match. Please try again.");
            return;
        }
        String passengerID = String.format("%02d", penumpang.size() + 1);
        Passenger p = new Passenger(passengerID, id, name, notel, pass);
        penumpang.add(p);
        p.displayProfile();

    }

    // student login
    public void studentlogin() {
        System.out.println("\n--- Student Login ---");
        System.out.print("Student ID : ");
        String id = sc.nextLine();
        System.out.print("Password   : ");
        String pass = sc.nextLine();

        for (Driver d : Pemandu) {
            if (d.loginStudent(id, pass)) {
                System.out.println("Login Successfull");
                System.out.println("Welcome: " + d.getStudent_name());
                System.out.println("Role: Driver");
                DashboardDriver(d);
                return;
            }
        }

        for (Passenger p : penumpang) {
            if (p.loginStudent(id, pass)) {
                System.out.println("Login Successfull");
                System.out.println("Welcome: " + p.getStudent_name());
                System.out.println("Role: Passenger");
                DashboardPass(p);
                return;
            }

        }
        System.out.println("[Warning] Incorrect Student ID or password.");

    }    
    
    // admin login
    public void adminLogin() {

        System.out.println("\n--- ADMIN LOGIN ---");
        System.out.print("Admin ID : ");
        String id = sc.nextLine();
        System.out.print("Password : ");
        String pass = sc.nextLine();

        for (Admin a : Ketua) {
            if (a.loginAdmin(id, pass)) {
            dashboardAdmin(a);
            return;
            }
        }
        System.out.println("[Warning] Invalid Admin ID or password.");
    }

    

    // driver approve booking passenger
    public void approveBookings(Driver driver) {
        ArrayList<booking> pending = booking.displayPending(bookings, driver);

        System.out.print("Select booking to manage (0 to cancel): ");
        int choice = sc.nextInt();
        sc.skip("\\R?");
        if (choice > 0 && choice <= pending.size()) {
            booking selected = pending.get(choice - 1);
            System.out.print("Approve or Reject? (1: Approve, 2: Reject): ");
            int action = sc.nextInt();
            sc.skip("\\R?");

            if (action == 1) {
                selected.Approvebooking("CONFIRMED");
                System.out.println("Booking approved!");
            } else if (action == 2) {
                selected.Approvebooking("REJECTED");
                System.out.println("Booking rejected!");
            } else {
                System.out.println("Invalid action.");
            }
        }
    }
    
    // passenger submit feedback
    public void submitFeedback(Passenger pass) {

        System.out.println("\n----- SUBMIT FEEDBACK -----");

        // show drivers
        if (Pemandu.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }

        Feedback ftest = new Feedback();
        
        ftest.displayDriver(Pemandu);

        System.out.print("Choose Driver: ");
        int choice = sc.nextInt();
        sc.skip("\\R?");

        if (choice < 1 || choice > Pemandu.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Driver selectedDriver = Pemandu.get(choice - 1);

        System.out.print("Enter your feedback: ");
        String fdMessage = sc.nextLine();

        Feedback f = new Feedback(String.valueOf(feeds.size() + 1),fdMessage,pass,selectedDriver
    );
        feeds.add(f);
        System.out.println(f.submitFeedback());
    }

    // driver submit report
    public void submitReport(Driver driver) {

        System.out.println("\n----- SUBMIT REPORT -----");

        System.out.print("Report Subject: ");
        String type = sc.nextLine();

        System.out.print("Enter Report Details: ");
        String details = sc.nextLine();
        
        Report r = new Report(String.valueOf(reports.size() + 1), driver, type, details);
        

        reports.add(r);

        System.out.println("Report submitted successfully!");
    }
    
    // driver punya dashboard
    public void DashboardDriver(Driver driver) {

        System.out.println("");

        System.out.println("================================================================================");
        System.out.println("                  t-UMPang:UMPSA Campus Carpool Management System               ");
        System.out.println("================================================================================");
        System.out.println("|                                   1)View Profile                             |");
        System.out.println("|                                   2)Carpool List                             |");
        System.out.println("|                                   3)View My Trip                             |");
        System.out.println("|                                   4)Post New Trip                            |");
        System.out.println("|                               5)Manage Booking Request                       |");
        System.out.println("|                                   6)Submit Report                            |");
        System.out.println("|                                   7)View Ongoing Trips                       |");
        System.out.println("|                                      0)Logout                                |");
        System.out.println("================================================================================");

        System.out.print("Choice: ");

        int choice = sc.nextInt();
        sc.skip("\\R?");
        if (choice == 1){
            driver.displayProfile();
            DashboardDriver(driver);
        }
        else if (choice == 2) {

            Carpool.displayCarpool(carpools);
            DashboardDriver(driver);

        }
        else if (choice == 3) {
            System.out.println("\n=== MY TRIPS ====");
            Carpool.displayCarpool(driver.getMyCarpools());
            DashboardDriver(driver);
        }
        else if (choice == 4) {
            if (PemanduApproved.contains(driver.getDriver_id())) {
                Carpool.createCarpool(driver, carpools);
            } else {
                System.out.println("\n[WARNING] Your account has not been approved by admin yet.");
            }  

            DashboardDriver(driver);

            
        } else if (choice == 5) {
            if (PemanduApproved.contains(driver.getDriver_id())){
                approveBookings(driver);
                
            }
            else {
                System.out.println("\n[WARNING] Your account has not been approved by admin yet.");            
            } 
            DashboardDriver(driver);


        }     
                
        else if (choice == 6){
            submitReport(driver);
            DashboardDriver(driver);
        }
        else if (choice == 7) {
            System.out.println("======= START TRIPS ========");
            ArrayList<booking> confirmed = booking.displayConfirmed(bookings, driver);

            if (!confirmed.isEmpty()) {
                System.out.print("Select booking to start trip (0 to cancel): ");
                int choiceStart = sc.nextInt();
                sc.skip("\\R?");

                if (choiceStart > 0 && choiceStart <= confirmed.size()) {
                    booking selected = confirmed.get(choiceStart - 1);
                    selected.startTrip();
                    System.out.println("Trip started! Have a safe journey!");
                }
            }
            DashboardDriver(driver);
        }
        else if (choice == 0) {
            System.out.println("Logged out. Goodbye, " + driver.getStudent_name() + "!");
            return; 
        }
    }

    // passenger punya dashboard
    public void DashboardPass(Passenger pass) {

        System.out.println("");

        System.out.println("================================================================================");
        System.out.println("                  t-UMPang:UMPSA Campus Carpool Management System               ");
        System.out.println("================================================================================");
        System.out.println("|                                  1)View Profile                              |");
        System.out.println("|                               2)Search and Book Trip                         |");
        System.out.println("|                                   3)Carpool List                             |");
        System.out.println("|                                  4)View My Booking                           |");
        System.out.println("|                                  5)Cancel Booking                            |");
        System.out.println("|                                 6) Complete the Trip                         |");
        System.out.println("|                                   7)Give Feedback                            |");
        System.out.println("|                                    8)Trip History                            |");
        System.out.println("|                                      0)Logout                                |");
        System.out.println("================================================================================");

        System.out.print("Choice: ");

        int choice = sc.nextInt();
        sc.skip("\\R?");
        if ( choice == 1){
            pass.displayProfile();
            DashboardPass(pass);
        }
        else if (choice == 2) {

            boolean found = pass.searchCarpool(carpools);

            if (found) {

                System.out.print("Enter Carpool ID: ");
                String id = sc.nextLine();

                booking temp = new booking("temp", pass, null, "", "");

                booking b = temp.createBooking(pass, carpools, id);

                if (b != null) {
                    bookings.add(b);
                    System.out.println("Booking successful!");
                }
            }

            DashboardPass(pass);
        }
        else if (choice == 3){
            Carpool.displayCarpool(carpools);
            System.out.print("Enter Carpool ID: ");
            String id = sc.nextLine();
            booking temp = new booking("temp", pass, null, "", "");

            booking b = temp.createBooking(pass, carpools, id);

            if (b != null) {
                bookings.add(b);
                System.out.println("Booking successful!");
            }
            DashboardPass(pass);
        }
        
        else if (choice == 4) {
            booking.displayMyBookings(bookings, pass);
            DashboardPass(pass);
        } else if (choice == 5) {
            booking.displayMyBookings(bookings, pass);
            System.out.println("Enter Booking ID: ");
            String bid = sc.nextLine();
            pass.cancelBooking(bookings, bid);
            DashboardPass(pass);
        } else if (choice == 6) {

            System.out.println("\n=== ONGOING TRIP ===");

            ArrayList<booking> ongoing = booking.displayOngoing(bookings, pass);

            if (!ongoing.isEmpty()) {

                System.out.print("Select booking: ");
                int choiceTrip = sc.nextInt();

                if (choiceTrip > 0 && choiceTrip <= ongoing.size()) {

                    ongoing.get(choiceTrip - 1).completeTrip();

                    System.out.println("Trip completed!");
                }
            }
            DashboardPass(pass);
        }
        else if (choice == 7){
            submitFeedback(pass);
            DashboardPass(pass);
        }
        else if (choice == 8){
            pass.checkHistory(bookings);
            DashboardPass(pass);
        }
        
        else if (choice == 0) {
            System.out.println("Logged out. Goodbye, " + pass.getStudent_name() + "!");
            return;
        }
    }
    
    // admin tengok driver punya report
    public void viewAllReports(){
        System.out.println("\n----- DRIVER REPORTS -----");
        if(reports.isEmpty()){
            System.out.println("No reports submitted.");
            return;
        }
        for (Report r : reports){
            System.out.println(r);
        }        
    }
    
    // admin punya dashboard
    public void dashboardAdmin(Admin admins) {
        System.out.println("");
        System.out.println("=========================================");
        System.out.println("  UMPSA Campus Carpool Management System ");
        System.out.println("=========================================");
        System.out.println("|          1)Approve Driver              |");
        System.out.println("|          2)View All Driver             |");
        System.out.println("|          3)View Feedbacks              |");
        System.out.println("|          4)View Driver Report          |");
        System.out.println("|               5)Exit                   |");
        System.out.println("=========================================");
        System.out.print("Choice: ");

        int choice = sc.nextInt();
        sc.skip("\\R?");
        
        switch (choice){
            case 1:
                Admin.approveDriver(Pemandu, PemanduApproved);
                dashboardAdmin(admins);
                break;
            case 2:
                Admin.viewAllDriver(Pemandu);
                dashboardAdmin(admins);
                break;
            case 3:
                Admin.viewFeedback(feeds);
                dashboardAdmin(admins);
                break;
            case 4:
                viewAllReports();
                dashboardAdmin(admins);
                break;
            case 5:
                System.out.println("Exiting....");                
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                dashboardAdmin(admins);
        }
    }
}
