/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ucms;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author harir
 */
public class UCMS {
    private Scanner sc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // pakai array data ni untuk visualize je , nnti kita buat database
        Driver d1 = new Driver("D001", "DL123", "S001", "Ali", "0123456789", "pass123");
        Driver d2 = new Driver("D002", "DL456", "S002", "Aina", "0198765432", "pass123");
        Driver d3 = new Driver("D003", "DL789", "S003", "Hafiz", "0112233445", "pass123");
        Driver d4 = new Driver("D004", "DL321", "S004", "Sara", "0167788990", "pass123");
        Driver d5 = new Driver("D005", "DL654", "S005", "Zaki", "0135566778", "pass123");

        // ArrayList untuk simpan carpool
        ArrayList<Carpool> carpools = new ArrayList<>();

        carpools.add(new Carpool("C001", d1, "KLCC", "2026-05-07", 2, 3, "Gombak"));
        carpools.add(new Carpool("C002", d2, "Mid Valley", "2026-05-08", 3, 2, "Batu Caves"));
        carpools.add(new Carpool("C003", d3, "Sunway Pyramid", "2026-05-09", 1, 4, "Shah Alam"));
        carpools.add(new Carpool("C004", d4, "IOI City Mall", "2026-05-10", 2, 2, "Cheras"));

        
        //For carpool 
        //driver view
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- UCMS Menu ---");
            System.out.println("1. Create Carpool");
            System.out.println("2. Display All Carpools");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                Carpool.createCarpool(d1, carpools); 
            } else if (choice == 2) {
                Carpool.displayCarpool(carpools);
            } else if (choice == 3) {//create booking
                Carpool.displayCarpool(carpools);
            } else if (choice == 4) {//delete booking
                Carpool.displayCarpool(carpools);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
    //For Booking
    //user view
}
