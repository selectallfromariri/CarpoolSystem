/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeebag;

import java.util.Scanner;

/**
 *
 * @author harir
 */
public class CoffeeSalesArray {
    public static void main(String[] args) {
        Buyer ahmad =  new Buyer("Ahmad");
        Scanner input = new Scanner(System.in);
        
        System.out.println("Order Form");
        System.out.println("\n Enter Number Of Order : ");
        int numbOrder = input.nextInt();
        
        System.out.println("");
        //create array
        CoffeeBag[] cbag = new CoffeeBag[numbOrder];
        
        //prompt user to input of coffee bag
        for(int i = 0; i < cbag.length; i ++){
            System.out.println("Order Number " + (i + 1));
            System.out.println("Enter Coffee Type : " );
            String Ctype = input.next();
            System.out.println("Number no of bag : " );
            int bag = input.nextInt();
            System.out.println("Enter Weight : ");
            double weight = input.nextDouble();
            System.out.println("Enter Price KG : " );
            double price = input.nextDouble();
            
            //assign value to object in array
            cbag[i] = new CoffeeBag(Ctype, bag, weight, price);
            
            
        }
        
        
        ahmad.display(cbag);
        
        double totalOrderPrice = 0;
        double totalOrderPriceWTax = 0;
        double average =0;
        
        for(int i = 0; i < cbag.length; i++){
            totalOrderPrice += cbag[i].totalPrice();
            average = totalOrderPrice / cbag.length;
            
            totalOrderPriceWTax += cbag[i].TotalPriceWithTax();
            
        }
        System.out.println("Total Sales");
        System.out.println("Total order Price : RM " + totalOrderPrice);
        System.out.println("total order Price With tax : RM " + totalOrderPriceWTax);
        
    }
}