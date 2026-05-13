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

                    return new booking(
                            "B" + System.currentTimeMillis(),
                            pass,
                            c,
                            "2026-05-13",
                            "CONFIRMED"
                    );

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
                    b.getCarpool().getAvailableSeat() + 1
            );
            return true;
        }

        return false;
    }
}
