/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7coffesalessystem;

/**
 *
 * @author harir
 */
public class PackagingDetails {
    private int bagSold;
    private int bagWeight;
    private double pricePerKg;
    
    public PackagingDetails(int bagSold, int bagWeight, double pricePerKg){
        this.bagSold = bagSold;
        this.bagWeight = bagWeight;
        this.pricePerKg = pricePerKg;
    }

    public int getBagSold() {
        return bagSold;
    }

    public int getBagWeight() {
        return bagWeight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setBagSold(int bagSold) {
        this.bagSold = bagSold;
    }

    public void setBagWeight(int bagWeight) {
        this.bagWeight = bagWeight;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }
    
}

