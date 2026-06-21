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

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setCarpool(Carpool carpool) {
        this.carpool = carpool;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    

    public static booking createBooking(Passenger pass, ArrayList<Carpool> pool, String carpoolID) {
        Carpool selected = null;
        for (Carpool c : pool) {
            if (c.getCarpoolID().equalsIgnoreCase(carpoolID)) {
                selected = c;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Carpool not found.");
            return null;
        }

        if (selected.getAvailableSeat() <= 0) {
            System.out.println("No seats available.");
            return null;
        }

        selected.setAvailableSeat(selected.getAvailableSeat() - 1);
//        String id = "BK" + System.currentTimeMillis();

        String id = "BK-" + selected.getDestination().substring(0, 3).toUpperCase() + "-" + pass.getStudent_id().substring(2, 6) + selected.getDrive().getStudent_id().substring(2, 6) + selected.getDate().replace("/", "").substring(2);
        return new booking(id, pass, selected, selected.getDate(), "PENDING");
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
            if (b.getCarpool().getDrive().getStudent_id().equals(driver.getStudent_id())&& b.getBookingStatus().equalsIgnoreCase("PENDING")) {
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

    public static ArrayList<booking> displayMyBookings(ArrayList<booking> bookings, Passenger pass) {
        System.out.println("\n--- Your Bookings ---");
        ArrayList<booking> myBookings = new ArrayList<>();
        
        for (booking b : bookings) {
            if (b.getPassenger().getStudent_id().equals(pass.getStudent_id()) && !b.getBookingStatus().equalsIgnoreCase("CANCELLED")) {
                myBookings.add(b);
            }
            
        }
        if (myBookings.isEmpty()){
            System.out.println(" No bookings found.");
            return myBookings;
        }
        
        for(int i = 0; i< myBookings.size();i++){
            System.out.println((i+1)+")");
            myBookings.get(i).displayBooking();
        }
        
        return myBookings;
        
    }

}
