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

    ArrayList<Passenger> penumpang = new ArrayList<>();
    ArrayList<Driver> Pemandu = new ArrayList<>();
    ArrayList<Admin> Ketua = new ArrayList<>();
    ArrayList<Student> Pelajar = new ArrayList<>();
    ArrayList<Carpool> carpools = new ArrayList<>();
    ArrayList<booking> bookings = new ArrayList<>();

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
        while (true) {
            app.menu();
        }
        //
        // Carpool[] carpools = new Carpool[5];
        //
        // carpools[0] = new Carpool("C001", d1, "KLCC", "2026-05-07", 2, 3, "Gombak");
        // carpools[1] = new Carpool("C002", d2, "Mid Valley", "2026-05-08", 3, 2, "Batu
        // Caves");
        // carpools[2] = new Carpool("C003", d3, "Sunway Pyramid", "2026-05-09", 1, 4,
        // "Shah Alam");
        // carpools[3] = new Carpool("C004", d4, "IOI City Mall", "2026-05-10", 2, 2,
        // "Cheras");
        // carpools[4] = null;
    }

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

    }

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

    }

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
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("Phone Number: ");
        String notel = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Confirm Pass: ");
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
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("Phone Number: ");
        String notel = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Confirm Pass: ");
        String cpass = sc.nextLine();

        Passenger p = new Passenger("01", id, name, notel, pass);
        penumpang.add(p);
        p.displayProfile();

    }

    public void approveBookings(Driver driver) {
        System.out.println("\n--- Pending Bookings for Your Carpools ---");
        ArrayList<booking> pending = new ArrayList<>();

        for (booking b : bookings) {
            if (b.getCarpool().getDrive().getStudent_id().equals(driver.getStudent_id())
                    && b.getBookingStatus().equalsIgnoreCase("PENDING")) {
                pending.add(b);
            }
        }

        if (pending.isEmpty()) {
            System.out.println("No pending bookings found.");
            return;
        }

        for (int i = 0; i < pending.size(); i++) {
            booking b = pending.get(i);
            System.out.println((i + 1) + ") Booking ID: " + b.getBookingID());
            System.out.println("   Passenger: " + b.getPassenger().getStudent_name());
            System.out.println("   Destination: " + b.getCarpool().getDestination());
            System.out.println("   Date: " + b.getBookingDate());
            System.out.println("-------------------------");
        }

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

            Carpool.createCarpool(driver, carpools);
            DashboardDriver(driver);

        } else if (choice == 5) {

            approveBookings(driver);
            DashboardDriver(driver);

        }

    }

    public void DashboardPass(Passenger pass) {

        System.out.println("");
        System.out.println("================================================================================");
        System.out.println("                  t-UMPang:UMPSA Campus Carpool Management System               ");
        System.out.println("================================================================================");
        System.out.println("|                                  1)View Profile                              |");
        System.out.println("|                               2)Search and Book Trip                         |");
        System.out.println("|                                  3)View My Booking                           |");
        System.out.println("|                                  4)Cancel Booking                            |");
        System.out.println("|                                 5)Update Status Trip                         |");
        System.out.println("|                                   6)Give Feedback                            |");
        System.out.println("|                                    7)Trip History                            |");
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
            
            pass.searchCarpool(carpools);

            System.out.print("Enter Carpool ID: ");
            String id = sc.nextLine();

            booking temp = new booking("temp", pass, null, "", "");

            booking b = temp.createBooking(pass, carpools, id);

            if (b != null) {
                bookings.add(b);
                System.out.println("Booking successful!");
            }
            DashboardPass(pass);
        } else if (choice == 3) {
            System.out.println("\n--- Your Bookings ---");
            boolean found = false;
            for (booking b : bookings) {
                if (b.getPassenger().getStudent_id().equals(pass.getStudent_id())) {
                    System.out.println("Booking ID: " + b.getBookingID());
                    System.out.println("Carpool ID: " + b.getCarpool().getCarpoolID());
                    System.out.println("Destination: " + b.getCarpool().getDestination());
                    System.out.println("Date: " + b.getBookingDate());
                    System.out.println("Status: " + b.getBookingStatus());
                    System.out.println("-------------------");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No booking found.");
            }
            DashboardPass(pass);
        } else if (choice == 4) {
            System.out.println("Enter Booking ID: ");
            String bid = sc.nextLine();
            booking target = null;
            for (booking b : bookings) {
                if (b.getBookingID().equalsIgnoreCase(bid)) {
                    target = b;
                    break;
                }
            }
            booking temp = new booking("temp", pass, null, "", "");
            if (temp.cancelBooking(target)) {

                bookings.remove(target);
                System.out.println("Booking cancelled.");

            } else {
                System.out.println("Invalid booking.");
            }
            DashboardPass(pass);
        } else if (choice == 5) {
            pass.searchCarpool(carpools);
            DashboardPass(pass);
        }
    }
}
