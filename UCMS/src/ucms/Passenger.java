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
    private String bookingStatus;
    private Carpool date;
    private Carpool carpoolID;

    public Passenger(String passengerID, String student_id, String student_name, String phone_num, String password) {
        super(student_id, student_name, phone_num, password);
        this.passengerID = "PS" + passengerID;
        this.bookingStatus = "pending";
        // this.date = date;
        // this.carpoolID = carpoolID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

//    public String getBookingStatus() {
//        return bookingStatus;
//    }
//
//    public void setBookingStatus(String bookingStatus) {
//        this.bookingStatus = bookingStatus;
//    }
//
//    public Carpool getDate() {
//        return date;
//    }
//
//    public void setDate(Carpool date) {
//        this.date = date;
//    }
//
//    public String getStudent_id() {
//        return student_id;
//    }
//
//    public void setStudent_id(String student_id) {
//        this.student_id = student_id;
//    }
//
//    public String getStudent_name() {
//        return student_name;
//    }
//
//    public void setStudent_name(String student_name) {
//        this.student_name = student_name;
//    }
//
//    public String getPhone_num() {
//        return phone_num;
//    }
//
//    public void setPhone_num(String phone_num) {
//        this.phone_num = phone_num;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Carpool getCarpoolID() {
        return carpoolID;
    }

    public void setCarpoolID(Carpool carpoolID) {
        this.carpoolID = carpoolID;
    }

        @Override
    public void displayProfile() { 
        super.displayProfile(); System.out.println("Passenger ID: " + passengerID); 
    }

 
    // search carpool
    public void searchCarpool(ArrayList<Carpool> carpool) {
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
            return;
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

    // tengok booking status
    public void viewBookingStatus() {
        System.out.println("----- BOOKING STATUS -----");
        System.out.println("Passenger ID   : " + passengerID);
        System.out.println("Passenger Name : " + student_name);
        System.out.println("Phone Number   : " + phone_num);

        if (bookingStatus.equalsIgnoreCase("NONE")) {
            System.out.println("Status   : No active booking");
        } else {
            System.out.println("Carpool ID     : " + carpoolID);
            System.out.println("Booking Status : " + bookingStatus);
            System.out.println("Booking Date   : " + date);
        }
    }

    // check history trip
    public void checkHistory(ArrayList<Carpool> carpool){
        System.out.println("----- TRIP HISTORY -----");
        System.out.println("Passenger    :" + student_name);
        System.out.println("Passenger ID : " + passengerID);

        boolean history = false;

        for (int i = 0; i < carpool.size(); i++) {

        if (carpool.get(i) != null && bookingStatus.equalsIgnoreCase("COMPLETED")) {
                System.out.println("----- PREVIOUS TRIP -----");
                System.out.println("Carpool ID      :" + carpool.get(i).getCarpoolID());
                System.out.println("Driver          : " + carpool.get(i).getDrive().getStudent_name());
                System.out.println("Pickup Location : " + carpool.get(i).getPickupLocation());
                System.out.println("Destination     : " + carpool.get(i).getDestination());
                System.out.println("Date            : " + carpool.get(i).getDate());
                System.out.println("Status        : COMPLETED");

                history = true;
            }
        }

        if (!history || bookingStatus.equalsIgnoreCase("NONE")) {
            System.out.println("No trip history in record.");
        }
    }

    // update status trip
    // ni belum kot
    public void updateStatusTrip() {
        Scanner input = new Scanner(System.in);
        System.out.println("----- TRIP STATUS -----");

        if (bookingStatus.equalsIgnoreCase("NONE")) {
            System.out.println("No active booking to update.");
            return;
        }
        System.out.println("Carpool ID      : " + carpoolID);
        System.out.println("Current Status  : " + bookingStatus);
        System.out.println("Booking Date    : " + date);

        switch (bookingStatus) {
            case "PENDING":
                System.out.println("Status  : Waiting for driver confirmation");
                break;
            case "CONFIRMED":
                System.out.println("Status  : Confirmed");
                break;
            case "ON THE WAY":
                System.out.println("Status  : Driver is on the way");
                break;
            case "ARRIVED":
                System.out.println("Status  : Driver has arrived");
                break;
            case "CANCELLED":
                System.out.println("Status  : Cancelled");
                break;
        }
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerID +
                "\nStudent ID: " + student_id +
                "\nName: " + student_name +
                "\nPhone: " + phone_num;
    }
}
