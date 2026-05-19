/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coffeebag;

/**
 *
 * @author harir
 */
public class CoffeeBag {

    /**
     * @param args the command line arguments
     */
    //variable
    private String coffeeType;
    private int bagSold;
    private double bagWeight;
    private double pricePerKg;
    private static double TaxRate;
    
    //default construcor
    public CoffeeBag(){
        coffeeType = null;
        bagSold = 0;
        bagWeight = 0.00;
        pricePerKg = 0.00;
        TaxRate = 7.25;
    }
    //parameter constructor
    public CoffeeBag(String coffeeType, int bagSold, double bagWeight, double pricePerKg){ 
        this.coffeeType = coffeeType;
        this.bagSold = bagSold;
        this.bagWeight = bagWeight;
        this.pricePerKg = pricePerKg;
    }
    
    public String getCoffeeType(){
        return coffeeType;
    }
    public int getBagSold(){
        return bagSold;
    }
    public double getbagWeight(){
        return bagWeight;
    }
    public double getpricePerKg(){
        return pricePerKg;
    }
    public void setCoffeeType(String coffeeType){
        this.coffeeType = coffeeType;
    }
    public void setBagSold(int bagSold){
        this.bagSold = bagSold;
    }
    public void setBagWeight(double bagWeight){
        this.bagWeight = bagWeight;
    }
    public void setpricePerKg(double pricePerKg){
        this.pricePerKg = pricePerKg;
    }
    
    public double totalPrice(){
        double totalPrice;
        return totalPrice = getBagSold()*getbagWeight()*getpricePerKg();
    }
    public double TotalPriceWithTax(){
        double TotalPriceWithTax;
        return TotalPriceWithTax = totalPrice()+(totalPrice()*TaxRate/100);
    }
    
}
