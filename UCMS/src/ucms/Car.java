/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

/**
 *
 * @author USER
 */
public class Car {
    private String numplate;
    private String model;
    private String color;
   

    public Car(String numplate, String model, String color) {
        this.numplate = numplate;
        this.model = model;
        this.color = color;
        
    }

    public String getNumplate() {
        return numplate;
    }

    public void setNumplate(String numplate) {
        this.numplate = numplate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void displayCarInfo() {
        System.out.println("Car Plate Number: " + numplate);
        System.out.println("Car Model: " + model);
        System.out.println("Car Color: " + color);
    }
}