/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.ArrayList;

/**
 *
 * @author harir
 */
public class booking {

    private String bookingID;
    private Passenger passenger;
    private Carpool carpool;
    private String bookingDate;
    private String bookingStatus;

    public booking(String bookingID, Passenger passenger, Carpool carpool, String bookingDate, String bookingStatus) {
        this.bookingID = bookingID;
        this.passenger = passenger;
        this.carpool = carpool;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Carpool getCarpool() {
        return carpool;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public booking createBooking(Passenger pass, ArrayList<Carpool> pool, String carpoolID) {

        for (Carpool c : pool) {

            if (c.getCarpoolID().equalsIgnoreCase(carpoolID)) {

                if (c.getAvailableSeat() > 0) {

                    c.setAvailableSeat(c.getAvailableSeat() - 1);

                    return new booking( "B" + System.currentTimeMillis(), pass,c,"2026-05-13","PENDING");

                } else {
                    System.out.println("No seats available.");
                    return null;
                }
            }
        }

        System.out.println("Carpool not found.");
        return null;
    }

    public boolean cancelBooking(booking b) {

        if (b != null) {
            b.getCarpool().setAvailableSeat(
            b.getCarpool().getAvailableSeat() + 1);
            return true;
        }

        return false;
    }

    public void startTrip() {
        bookingStatus = "ONGOING";
    }
    public void completeTrip(){
        bookingStatus = "COMPLETED";
    }
    public void Approvebooking(String status) {
        bookingStatus = status;
        if (status.equalsIgnoreCase("REJECTED")) {
            this.carpool.setAvailableSeat(this.carpool.getAvailableSeat() + 1);
        }
    }
    
    public static ArrayList<booking> displayPending(ArrayList<booking> bookings, Driver driver) {
        System.out.println("\n--- Pending Booking Requests ---");
        ArrayList<booking> pending = new ArrayList<>();
        for (booking b : bookings) {
            if (b.getCarpool().getDrive().getStudent_id().equals(driver.getStudent_id())
                    && b.getBookingStatus().equalsIgnoreCase("PENDING")) {
                pending.add(b);
            }
        }
        if (pending.isEmpty()) {
            System.out.println("No pending bookings found.");
            return pending;
        }
        for (int i = 0; i < pending.size(); i++) {
            System.out.println((i + 1) + ") Booking ID  : " + pending.get(i).getBookingID());
            System.out.println("   Passenger   : " + pending.get(i).getPassenger().getStudent_name());
            System.out.println("   Destination : " + pending.get(i).getCarpool().getDestination());
            System.out.println("   Date        : " + pending.get(i).getBookingDate());
            System.out.println("   -------------------------");
        }
        return pending;
        
    }
    
    public static ArrayList<booking> displayOngoing(ArrayList<booking> bookings, Passenger pass){
        ArrayList <booking> ongoing = new ArrayList<>();
        
        for (booking b : bookings){
            if (b.getPassenger().getStudent_id().equals(pass.getStudent_id()) && b.getBookingStatus().equalsIgnoreCase("ONGOING")) {
                ongoing.add(b);
            }
        }
        
        if(ongoing.isEmpty()){
            System.out.println("No Ongoing Trips");
            return ongoing;
        }
        for (int i = 0; i < ongoing.size(); i++) {

            booking b = ongoing.get(i);

            System.out.println((i + 1) + ") " + b.getBookingID());
            System.out.println("Driver: " + b.getCarpool().getDrive().getStudent_name());
            System.out.println("Destination: " + b.getCarpool().getDestination());
            System.out.println("-----------------------------------");
        }

        return ongoing;
    }
    
    public static ArrayList<booking> displayConfirmed(ArrayList<booking> bookings, Driver driver) {
        System.out.println("\n--- Confirmed Bookings (Ready to Start) ---");
        ArrayList<booking> confirmed = new ArrayList<>();

        for (booking b : bookings) {
            if (b.getCarpool().getDrive().getStudent_id().equals(driver.getStudent_id())
                    && b.getBookingStatus().equalsIgnoreCase("CONFIRMED")) {
                confirmed.add(b);
            }
        }

        if (confirmed.isEmpty()) {
            System.out.println("No confirmed bookings found.");
            return confirmed;
        }

        for (int i = 0; i < confirmed.size(); i++) {
            booking b = confirmed.get(i);
            System.out.println((i + 1) + ") Booking ID  : " + b.getBookingID());
            System.out.println("   Passenger   : " + b.getPassenger().getStudent_name());
            System.out.println("   Destination : " + b.getCarpool().getDestination());
            System.out.println("   Date        : " + b.getBookingDate());
            System.out.println("   -------------------------");
        }

        return confirmed;
    }
    
    public static void displayMyBookings(ArrayList<booking> bookings, Passenger pass) {
        System.out.println("\n--- Your Bookings ---");
        boolean found = false;
        for (booking b : bookings) {
            if (b.getPassenger().getStudent_id().equals(pass.getStudent_id())) {
                System.out.println("Booking ID  : " + b.getBookingID());
                System.out.println("Carpool ID  : " + b.getCarpool().getCarpoolID());
                System.out.println("Destination : " + b.getCarpool().getDestination());
                System.out.println("Date        : " + b.getBookingDate());
                System.out.println("Status      : " + b.getBookingStatus());
                System.out.println("-------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No booking found.");
        }
    }

 
    
}
