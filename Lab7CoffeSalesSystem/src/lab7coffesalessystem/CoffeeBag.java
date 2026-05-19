/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7coffesalessystem;

/**
 *
 * @author harir
 */
public class CoffeeBag {
    private final double taxRate = 7.25;
    private String coffeeType;
    private PackagingDetails details;
    
    public CoffeeBag(String coffeeType, int bagSold, int bagWeight, double pricePerKg){
        this.coffeeType = coffeeType;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public PackagingDetails getDetails() {
        return details;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public void setDetails(PackagingDetails details) {
        this.details = details;
    }
    
    public double totalPrice(){
        int sold = details.getBagSold();
        int weight = details.getBagWeight();
        double kg = details.getPricePerKg();
        
        double total = sold * weight * kg;
        return total;
    }
    
    public int getDiscountRate(){
        int discount;
        if(getCoffeeType().equalsIgnoreCase("Arabica")){
            if(details.getBagSold() >= 20 || details.getBagSold() <= 50){
                discount = 5;
            }else if(details.getBagSold() >= 51 || details.getBagSold() <= 100){
                discount = 7;
            }else if(details.getBagSold() > 100){
                discount = 10;
            }else{
                discount = 1;
            }
        }else if(getCoffeeType().equalsIgnoreCase("Robusta")){
            if(details.getBagSold() >= 10 || details.getBagSold() <= 25){
                discount = 7;
            }else if(details.getBagSold() >= 26 || details.getBagSold() <= 50){
                discount = 10;
            }else if(details.getBagSold() > 50){
                discount = 15;
            }else{
                discount = 1;
            }
        }else if(getCoffeeType().equalsIgnoreCase("Excelsa")){
            if(details.getBagSold() >= 50 || details.getBagSold() <= 70){
                discount = 10;
            }else if(details.getBagSold() >= 71 || details.getBagSold() <= 100){
                discount = 15;
            }else if(details.getBagSold() > 100){
                discount = 20;
            }else{
                discount = 1;
            }          
        }else if(getCoffeeType().equalsIgnoreCase("Liberica")){
            if(details.getBagSold() >= 15 || details.getBagSold() <= 30){
                discount = 10;
            }else if(details.getBagSold() >= 31 || details.getBagSold() <= 60){
                discount = 15;
            }else if(details.getBagSold() > 60){
                discount = 20;
            }else{
                discount = 1;
            }  
        }else{
            discount = 1;
        }
        return discount;
    }
    
    public double getPriceAfterDiscount(){
        double price = totalPrice();
        int discount = getDiscountRate();
        double deduct = price * discount;
        
        double afterDisc = price - deduct;
        return afterDisc;
    }
    
    public double totalPriceWithTax(){
        double afterDiscount = getPriceAfterDiscount();
        double tax = getTaxRate();
        double withtax = afterDiscount * (taxRate/100);
        
        return withtax;
    }
    
}
