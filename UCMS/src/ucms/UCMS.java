/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ucms;

import java.util.Scanner;

/**
 *
 * @author harir
 */
public class UCMS {
    private Scanner sc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        //pakai array data ni untuk visualize je , nnti kita buat database
        Driver d1 = new Driver("D001", "DL123", "S001", "Ali", "0123456789", "pass123");
        Driver d2 = new Driver("D002", "DL456", "S002", "Aina", "0198765432", "pass123");
        Driver d3 = new Driver("D003", "DL789", "S003", "Hafiz", "0112233445", "pass123");
        Driver d4 = new Driver("D004", "DL321", "S004", "Sara", "0167788990", "pass123");
        Driver d5 = new Driver("D005", "DL654", "S005", "Zaki", "0135566778", "pass123");

        Carpool[] carpools = new Carpool[5];

        carpools[0] = new Carpool("C001", d1, "KLCC", "2026-05-07", 2, 3, "Gombak");
        carpools[1] = new Carpool("C002", d2, "Mid Valley", "2026-05-08", 3, 2, "Batu Caves");
        carpools[2] = new Carpool("C003", d3, "Sunway Pyramid", "2026-05-09", 1, 4, "Shah Alam");
        carpools[3] = new Carpool("C004", d4, "IOI City Mall", "2026-05-10", 2, 2, "Cheras");
        carpools[4] = null;        
    }         
}
