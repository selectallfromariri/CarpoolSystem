/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.Scanner;

/**
 *
 * @author harir
 */
public class Carpool {

    private String carpoolID;
    private Driver drive;
    private String destination;
    private String date;
    private int luggageCapacity;
    private int availableSeat;
    private String pickupLocation;
    private Carpool[] pool;

    public Carpool(String carpoolID, Driver drive, String destination, String date, int luggageCapacity,
            int availableSeat, String pickupLocation) {

    }

    public String getCarpoolID() {
        return carpoolID;
    }

    public Driver getDrive() {
        return drive;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setCarpoolID(String carpoolID) {
        this.carpoolID = carpoolID;
    }

    public void setDrive(Driver drive) {
        this.drive = drive;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public int totalPassanger(Carpool[] pool) {
        int totpassenger = 0;
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null) {
                totpassenger += 1;
            }
        }
        return totpassenger;
    }

//    public boolean insertCarpool(Carpool[] pool, Carpool newCarpool) {
//        for (int i = 0; i < pool.length; i++) {
//            if (pool[i] == null) {
//                pool[i] = newCarpool;
//                return true;
//            }
//        }
//        return false;
//    }

    public void createCarpool() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Destination : ");
        String des = sc.next();
        System.out.println("Enter Date : ");
        String date = sc.next();
        System.out.println("Enter available Seat");
        int avSeat = sc.nextInt();
        System.out.println("Enter luggage capacity");
        int lugCap = sc.nextInt();
        System.out.println("pickup location : ");
        String loc = sc.next();

    }

    public void update(String des, String date, int avSeat, int lugCap, String loc) {
        setAvailableSeat(avSeat);
        setDate(date);
        setDestination(des);
        setLuggageCapacity(lugCap);
        setPickupLocation(loc);
    }

    public void displayCarpool(Carpool[] pool) {

        for (int i = 0; i < pool.length; i++) {

            if (pool[i] != null) {
                System.out.println("Carpool ID: " + pool[i].getCarpoolID());
                System.out.println("Driver: " + pool[i].getDrive().getStudent_name());
                System.out.println("Destination: " + pool[i].getDestination());
                System.out.println("Date: " + pool[i].getDate());
                System.out.println("Available Seat: " + pool[i].getAvailableSeat());
                System.out.println("Luggage Capacity: " + pool[i].getLuggageCapacity());
                System.out.println("Pickup Location: " + pool[i].getPickupLocation());
                System.out.println("-----------------------------------");
            }
        }
    }
    
    

}
