/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author yana
 */
public class Passenger extends Student {

    private String passengerID;

    public Passenger(String passengerID, String student_id, String student_name, String phone_num, String password) {
        super(student_id, student_name, phone_num, password);
        this.passengerID = "PS" + passengerID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Passenger ID: " + passengerID);
    }

    
    public boolean searchCarpool(ArrayList<Carpool> carpool, ArrayList<booking> bookings) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter carpool destination to search: ");
        String searchDestination = input.nextLine();

        ArrayList<Carpool> results = new ArrayList<>();
        for (Carpool c : carpool) {
            if (c != null && c.getDestination().equalsIgnoreCase(searchDestination)) {
                results.add(c);
            }
        }

        System.out.println("----- SEARCH RESULT -----");

        if (results.isEmpty()) {
            System.out.println("No carpool available to " + searchDestination);
            return false;
        }

        
        Carpool.displayAvailableCarpool(results, bookings);
        return true;
    }



    public static void displayAvailableCarpool(ArrayList<Carpool> pool, ArrayList<booking> bookings) {
        System.out.println("\n------- AVAILABLE CARPOOLS -------");
        boolean found = false;

        for (Carpool c : pool) {
            if (c == null || c.getAvailableSeat() <= 0) {
                continue;
            }

            boolean isCompleted = false;
            for (booking b : bookings) {
                if (b.getCarpool().getCarpoolID().equals(c.getCarpoolID()) && b.getBookingStatus().equalsIgnoreCase("COMPLETED")) {
                    isCompleted = true;
                    break;
                }
            }

            if (!isCompleted) {
                System.out.println("Carpool ID      : " + c.getCarpoolID());
                System.out.println("Driver          : " + c.getDrive().getStudent_name());
                System.out.println("Destination     : " + c.getDestination());
                System.out.println("Date            : " + c.getDate());
                System.out.println("Available Seat  : " + c.getAvailableSeat());
                System.out.println("Luggage Capacity: " + c.getLuggageCapacity());
                System.out.println("Pickup Location : " + c.getPickupLocation());
                System.out.println("-----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("  No available carpools at the moment.");
        }
    }

    public void cancelBooking(ArrayList<booking> bookings, int index) {

        ArrayList<booking> myBookings = new ArrayList<>();
        for (booking b : bookings) {
            if (b.getPassenger().getStudent_id().equals(this.student_id) && !b.getBookingStatus().equalsIgnoreCase("CANCELLED")) {
                myBookings.add(b);
            }
        }

        if (index < 1 || index > myBookings.size()) {
            System.out.println("[!] Invalid selection.");
            return;
        }

        booking selected = myBookings.get(index - 1);

        if (!selected.getBookingStatus().equalsIgnoreCase("PENDING")) {
            System.out.println("Can only cancel PENDING bookings. Current status: " + selected.getBookingStatus());
            return;
        }

        selected.setBookingStatus("CANCELLED");
        selected.getCarpool().setAvailableSeat(
                selected.getCarpool().getAvailableSeat() + 1);
        System.out.println("[-] Booking cancelled successfully.");
    }

    public void checkHistory(ArrayList<booking> bookings) {
        System.out.println("\n----- TRIP HISTORY -----");
        boolean found = false;
        for (booking b : bookings) {
            if (b.getPassenger().getStudent_id().equals(this.student_id)) {
                String status = b.getBookingStatus().toUpperCase();
                if (status.equals("COMPLETED") || status.equals("CANCELLED") || status.equals("REJECTED")) {
                    System.out.println("Booking ID  : " + b.getBookingID());
                    System.out.println("Destination : " + b.getCarpool().getDestination());
                    System.out.println("Date        : " + b.getBookingDate());
                    System.out.println("Status      : " + b.getBookingStatus());
                    System.out.println("-------------------");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No trip history yet.");
        }
    }

    public ArrayList<booking> getHistory(ArrayList<booking> bookings) {

        ArrayList<booking> history = new ArrayList<>();

        for (booking b : bookings) {

            if (b.getPassenger().getStudent_id().equals(this.student_id)) {

                String status = b.getBookingStatus().toUpperCase();

                if (status.equals("COMPLETED") || status.equals("CANCELLED") || status.equals("REJECTED")) {

                    history.add(b);
                }
            }
        }

        return history;
    }

    @Override
    public String getRole() {
        String role = "Passengers";
        return role;
    }
}
