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
        // this.bookingStatus = "pending";
        // this.date = date;
        // this.carpoolID = carpoolID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    // public String getBookingStatus() {
    // return bookingStatus;
    // }
    //
    // public void setBookingStatus(String bookingStatus) {
    // this.bookingStatus = bookingStatus;
    // }
    //
    // public Carpool getDate() {
    // return date;
    // }
    //
    // public void setDate(Carpool date) {
    // this.date = date;
    // }
    //
    // public String getStudent_id() {
    // return student_id;
    // }
    //
    // public void setStudent_id(String student_id) {
    // this.student_id = student_id;
    // }
    //
    // public String getStudent_name() {
    // return student_name;
    // }
    //
    // public void setStudent_name(String student_name) {
    // this.student_name = student_name;
    // }
    //
    // public String getPhone_num() {
    // return phone_num;
    // }
    //
    // public void setPhone_num(String phone_num) {
    // this.phone_num = phone_num;
    // }

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

    // search carpool
    public boolean searchCarpool(ArrayList<Carpool> carpool) {
        Scanner input = new Scanner(System.in);
        System.out.println("----- SEARCH -----");
        System.out.println("Enter pickup location to search: ");
        String pickupLocation = input.nextLine();
        boolean pickup = false;

        for (int i = 0; i < carpool.size(); i++) {
            if (carpool.get(i) != null && carpool.get(i).getPickupLocation().equalsIgnoreCase(pickupLocation)) {
                pickup = true;
                break;
            }
        }
        if (!pickup) {
            System.out.println("----- SEARCH RESULT -----");
            System.out.println("No carpool available from " + pickupLocation);
            return false;
        }
        System.out.println("Enter carpool destination to search: ");
        String searchDestination = input.nextLine();
        boolean foundDestination = false;

        System.out.println("----- SEARCH RESULT -----");
        for (int i = 0; i < carpool.size(); i++) {
            if (carpool.get(i) != null && carpool.get(i).getDestination().equalsIgnoreCase(searchDestination)
                    && carpool.get(i).getPickupLocation().equalsIgnoreCase(pickupLocation)) {
                displaySearchCarpool(carpool.get(i));
                foundDestination = true;
            }
        }
        if (!foundDestination) {
            System.out.println("No carpool available from " + pickupLocation + " to " + searchDestination);
        }
        return foundDestination;
    }

    // search result
    private void displaySearchCarpool(Carpool carpool) {
        System.out.println("\n----- CARPOOL DETAILS -----");
        System.out.println("Carpool ID       : " + carpool.getCarpoolID());
        System.out.println("Driver Name      : " + carpool.getDrive().getStudent_name());
        System.out.println("Destination      : " + carpool.getDestination());
        System.out.println("Pickup Location  : " + carpool.getPickupLocation());
        System.out.println("Date             : " + carpool.getDate());
        System.out.println("Available Seats  : " + carpool.getAvailableSeat());
        System.out.println("Luggage Capacity : " + carpool.getLuggageCapacity());
    }

    public void cancelBooking(ArrayList<booking> bookings, String bookingID) {

        for (booking b : bookings) {

            if (b.getBookingID().equalsIgnoreCase(bookingID)) {

                bookings.remove(b);

                System.out.println("Booking cancelled.");
                return;
            }
        }

        System.out.println("Invalid booking.");
    }

    // check history trip
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

    @Override
    public String toString() {
        return "Passenger ID: " + passengerID +
                "\nStudent ID: " + student_id +
                "\nName: " + student_name +
                "\nPhone: " + phone_num;
    }

    public String getRole() {
        String role = "Passengers";
        return role;
    }
}
