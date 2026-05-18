/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author harir
 */
public class Carpool {

    private String carpoolID;
    private Driver driver;
    private String destination;
    private String date;
    private int luggageCapacity;
    private int availableSeat;
    private String pickupLocation;
    private Carpool[] pool;

    public Carpool(String carpoolID, Driver drive, String destination, String date, int luggageCapacity,
            int availableSeat, String pickupLocation) {
        this.carpoolID = carpoolID;
        this.driver = drive;
        this.destination = destination;
        this.date = date;
        this.luggageCapacity = luggageCapacity;
        this.availableSeat = availableSeat;
        this.pickupLocation = pickupLocation;
    }

    public String getCarpoolID() {
        return carpoolID;
    }

    public Driver getDrive() {
        return driver;
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
        this.driver = drive;
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

    // public boolean insertCarpool(Carpool[] pool, Carpool newCarpool) {
    // for (int i = 0; i < pool.length; i++) {
    // if (pool[i] == null) {
    // pool[i] = newCarpool;
    // return true;
    // }
    // }
    // return false;
    // }

   public static void createCarpool(Driver driver, ArrayList<Carpool> carpools) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter Destination : ");
        String des = sc.nextLine();

        System.out.println("Enter Date : ");
        String date = sc.nextLine();

        System.out.println("Enter available Seat : ");
        int avSeat = sc.nextInt();

        System.out.println("Enter luggage capacity : ");
        int lugCap = sc.nextInt();
        sc.nextLine(); // buang enter

        System.out.println("Pickup location : ");
        String loc = sc.nextLine();
        String carpoolID = generateID(driver);
        // create object baru
        Carpool newCarpool = new Carpool( carpoolID,driver,des,date,lugCap,avSeat,loc);
        
        // append masuk ArrayList
        carpools.add(newCarpool);
        driver.addCarpoolDriver(newCarpool);
        System.out.println("Carpool added successfully!");
    }

    public static String generateID(Driver driver){
        String carpool_id  = driver.getStudent_name().substring(0, 3) + (int)(Math.random()*900+100) ;
        return carpool_id;
    } 
    public void update(String des, String date, int avSeat, int lugCap, String loc) {
        setAvailableSeat(avSeat);
        setDate(date);
        setDestination(des);
        setLuggageCapacity(lugCap);
        setPickupLocation(loc);
    }

    public static void displayCarpool(ArrayList<Carpool> pool) {
        if (pool.isEmpty()) {
            System.out.println("No carpool available");
            return;
        }

        for (int i = 0; i < pool.size(); i++) {

            if (pool.get(i) != null) {
                System.out.println("\n---Display Carpool---");
                System.out.println("Carpool ID: " + pool.get(i).getCarpoolID());
                System.out.println("Driver: " + pool.get(i).getDrive().getStudent_name());
                System.out.println("Destination: " + pool.get(i).getDestination());
                System.out.println("Date: " + pool.get(i).getDate());
                System.out.println("Available Seat: " + pool.get(i).getAvailableSeat());
                System.out.println("Luggage Capacity: " + pool.get(i).getLuggageCapacity());
                System.out.println("Pickup Location: " + pool.get(i).getPickupLocation());
                System.out.println("-----------------------------------");
            }
        }
    }
}
