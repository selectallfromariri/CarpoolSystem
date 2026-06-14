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
public class booking implements BookingInterface {

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

    @Override
    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public Carpool getCarpool() {
        return carpool;
    }

    @Override
    public String getBookingID() {
        return bookingID;
    }

    @Override
    public String getBookingDate() {
        return bookingDate;
    }

    @Override
    public String getBookingStatus() {
        return bookingStatus;
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

    public void completeTrip() {
        bookingStatus = "COMPLETED";
    }

    public void Approvebooking(String status) {
        bookingStatus = status;
        if (status.equalsIgnoreCase("REJECTED")) {
            this.carpool.setAvailableSeat(this.carpool.getAvailableSeat() + 1);
        }
    }

    @Override
    public void displayBooking() {
        System.out.println("Booking ID  : " + bookingID);
        System.out.println("Passenger   : " + passenger.getStudent_name());
        System.out.println("Destination : " + carpool.getDestination());
        System.out.println("Date        : " + bookingDate);
        System.out.println("Status      : " + bookingStatus);
        System.out.println("-------------------");
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
            System.out.println((i + 1) + ")");
            pending.get(i).displayBooking(); 
        }
        return pending;
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
            System.out.println((i + 1) + ")");
            confirmed.get(i).displayBooking();  
        }
        return confirmed;
    }

    public static ArrayList<booking> displayOngoing(ArrayList<booking> bookings, Passenger pass) {
        System.out.println("\n--- Ongoing Trips ---");
        ArrayList<booking> ongoing = new ArrayList<>();
        for (booking b : bookings) {
            if (b.getPassenger().getStudent_id().equals(pass.getStudent_id())
                    && b.getBookingStatus().equalsIgnoreCase("ONGOING")) {
                ongoing.add(b);
            }
        }
        if (ongoing.isEmpty()) {
            System.out.println("No ongoing trips.");
            return ongoing;
        }
        for (int i = 0; i < ongoing.size(); i++) {
            System.out.println((i + 1) + ")");
            ongoing.get(i).displayBooking();  
        }
        return ongoing;
    }

    public static void displayMyBookings(ArrayList<booking> bookings, Passenger pass) {
        System.out.println("\n--- Your Bookings ---");
        boolean found = false;
        for (booking b : bookings) {
            if (b.getPassenger().getStudent_id().equals(pass.getStudent_id())) {
                b.displayBooking();  
                found = true;
            }
        }
        if (!found) {
            System.out.println("No booking found.");
        }
    }

}
