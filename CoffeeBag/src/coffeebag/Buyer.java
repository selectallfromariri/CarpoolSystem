/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeebag;

/**
 *
 * @author harir
 */
public class Buyer {
    private String name;
    
    public Buyer(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void display(CoffeeBag[] bag){
        System.out.println("Order for name : " + name);
        
        for(int i = 0; i < bag.length; i++){
            
        System.out.println("Coffee Type : " + bag[i].getCoffeeType());
        System.out.println("Number of Coffee : " + bag[i].getBagSold());
        System.out.println("Weight : " + bag[i].getbagWeight());
        System.out.println("Price : " + bag[i].getpricePerKg());
//      System.out.println("Total Price : " + bag[i].totalPrice());
//      System.out.println("Total Price with tax : " + bag[i].TotalPriceWithTax());
        System.out.println("\n");
        }
       
    }
    
//        public void display(CoffeeBag bag){
//        System.out.println("Coffee Type : " + bag.getCoffeeType());
//        System.out.println("Number of Coffee : " + bag.getBagSold());
//        System.out.println("Weight : " + bag.getbagWeight());
//        System.out.println("Price : " + bag.getpricePerKg());
//        System.out.println("Total Price : " + bag.totalPrice());
//        System.out.println("Total Price With tax : " + bag.TotalPriceWithTax());
//        System.out.println("/n");
//    }
}
