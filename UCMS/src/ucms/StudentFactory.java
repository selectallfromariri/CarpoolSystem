/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

/**
 *
 * @author User
 */
public class StudentFactory {
    
    
    public static Student createStudent(String role,String studentId,String name,String phone,String password, String driverId,String license, String plate,String model,String color) {

        
        if (role.equalsIgnoreCase("Driver")){
            Driver pemandubaru = new Driver(driverId, license, studentId, name, phone, password, plate, model, color);
            return pemandubaru;
        }
        else if (role.equalsIgnoreCase("Passenger")){
            String passId = String.format("%02d", 1);
            Passenger penumpangbaru = new Passenger(passId, studentId, name, phone, password);
            return penumpangbaru;
        }
         else {
            System.out.println("[!] Unknown role: " + role);
            return null;
        }
    }
}
