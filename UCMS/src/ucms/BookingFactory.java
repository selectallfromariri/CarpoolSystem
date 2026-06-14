/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BookingFactory {
    public static BookingInterface createBooking(Passenger pass,ArrayList<Carpool> pool,String carpoolID) {
        // Find the carpool
        Carpool selected = null;
        for (Carpool c : pool) {
            if (c.getCarpoolID().equalsIgnoreCase(carpoolID)) {
                selected = c;
                break;
            }
        }

        // Carpool not found
        if (selected == null) {
            System.out.println("[!] Carpool not found.");
            return null;
        }

        // No seats left
        if (selected.getAvailableSeat() <= 0) {
            System.out.println("[!] No seats available.");
            return null;
        }

        // Create booking — factory handles the object creation
        selected.setAvailableSeat(selected.getAvailableSeat() - 1);
        String id = "BK-" + System.currentTimeMillis();
        return new booking(id, pass, selected, "2026-05-13", "PENDING");
    }
}
