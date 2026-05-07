/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

/**
 *
 * @author harir
 */
public class booking {

    private String bookingID;
    private String bookingDate;
    private String bookingStatus;

    public booking(String bookingID, String bookingDate, String bookingStatus) {
        this.bookingDate = bookingDate;
        this.bookingID = bookingID;
        this.bookingStatus = bookingStatus;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
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

    public String createBooking(Carpool[] pool, String carpoolID) {
        for (int i = 0; i < pool.length; i++) {

            if (pool[i] != null && pool[i].getCarpoolID().equals(carpoolID)) {

                if (pool[i].getAvailableSeat() > 0) {

                    pool[i].setAvailableSeat(pool[i].getAvailableSeat() - 1);

                    return "Booking successful for Carpool ID: " + carpoolID;
                } else {
                    return "No seats available for this carpool.";
                }
            }
        }
        return "Carpool not found.";
    }

    public String cancelBooking(Carpool[] pool, String carpoolID) {

        for (int i = 0; i < pool.length; i++) {

            if (pool[i] != null && pool[i].getCarpoolID().equals(carpoolID)) {

                // restore seat (cancel booking)
                pool[i].setAvailableSeat(pool[i].getAvailableSeat() + 1);

                return "Booking cancelled for Carpool ID: " + carpoolID;
            }
        }

        return "Carpool not found.";
    }
}
