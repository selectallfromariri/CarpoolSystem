/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicleapp;

/**
 *
 * @author harir
 */
public class Vehicle {
   
    public static void main(String[] args){ 
    VehicleApp vehicle1= new VehicleApp("SUV", "Automatic", "Hybrid");
    VehicleApp vehicle2= new VehicleApp("lorry", "Manual", "Gasoline");
    
//    System.out.println("Accelerate: Current Speed : " + vehicle1.accelerate());
//    System.out.println("Brake: Current Speed : " + vehicle1.brake());
    System.out.println(vehicle1.getPowerTrain() + " Car with " + vehicle1.getTransmission() + " Transmission");
    System.out.println("Roadtax total is equal : " + vehicle1.getRoadTaxPrice());
    System.out.println("Auto Accelerate :" + vehicle1.autoAccelerate(2));
    System.out.println("Auto Brake :" + vehicle1.autobrake(2));
    }
}
