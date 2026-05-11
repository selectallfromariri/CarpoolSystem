/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ucms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author harir
 */
public class UCMS {
    private Scanner sc;

    public UCMS() {
        sc = new Scanner(System.in);
    }
    ArrayList <Passenger> penumpang = new ArrayList<>();
    ArrayList <Driver> Pemandu = new ArrayList<>();
    ArrayList <Admin> Ketua = new ArrayList<>();
    ArrayList <Student> Pelajar = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        //pakai array data ni untuk visualize je , nnti kita buat database

        
        UCMS app = new UCMS();
        while (true){
             app.menu();
        }
       
        
//        Student [] account = new Student[5];
//        
//        account[0] = new Student("RC23266", "Danish Danial", "011-29234038", "Danish@077");
//        account[1] = new Student("RC23266", "Danish Danial", "011-29234038", "Danish@077");
//        account[2] = new Student("RC23266", "Danish Danial", "011-29234038", "Danish@077");
//        account[3] = new Student("RC23266", "Danish Danial", "011-29234038", "Danish@077");
//        account[4] = new Student("RC23266", "Danish Danial", "011-29234038", "Danish@077");
       
        
        
        

//
//        Carpool[] carpools = new Carpool[5];
//
//        carpools[0] = new Carpool("C001", d1, "KLCC", "2026-05-07", 2, 3, "Gombak");
//        carpools[1] = new Carpool("C002", d2, "Mid Valley", "2026-05-08", 3, 2, "Batu Caves");
//        carpools[2] = new Carpool("C003", d3, "Sunway Pyramid", "2026-05-09", 1, 4, "Shah Alam");
//        carpools[3] = new Carpool("C004", d4, "IOI City Mall", "2026-05-10", 2, 2, "Cheras");
//        carpools[4] = null;        
    }   
    public void menu(){
        
        System.out.println("=========================================");
        System.out.println("  UMPSA Campus Carpool Management System ");
        System.out.println("=========================================");
        System.out.println("|             1)Register                |");
        System.out.println("|          2)Login as Student           |");
        System.out.println("|          3)Login as Admin             |");
        System.out.println("|               4)Exit                  |");
        System.out.println("=========================================");
        
        System.out.print("Choice: ");
        int choice  = sc.nextInt();
        sc.skip("\\R?");
        
        if(choice == 1) {
            registerMenu();
        }
        else if ( choice == 2){
            studentlogin();
        }
        
        
    }
    public void registerMenu() {
        System.out.println("");
        System.out.println("=========================================");
        System.out.println("  UMPSA Campus Carpool Management System ");
        System.out.println("=========================================");
        System.out.println("|          1)Register  as Driver        |");
        System.out.println("|          2)Register as Passenger      |");
        System.out.println("|               3)Exit                  |");
        System.out.println("=========================================");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.skip("\\R?");
        if(choice == 1){
            registerDriver();
        }
        else if(choice ==2){
            registerPassenger();
        }

    }
    public void studentlogin(){
        System.out.println("\n--- Student Login ---");
        System.out.print("Student ID : "); 
        String id   = sc.nextLine();
        System.out.print("Password   : "); 
        String pass = sc.nextLine();
        
        for(Driver d: Pemandu){
            if(d.loginStudent(id, pass)){
                System.out.println("Login Successfull");
                System.out.println("Welcome: " + d.getStudent_name());
                System.out.println("Role: Passenger");
                return;
            }
        }
        
        for(Passenger p: penumpang){
            if(p.loginStudent(id, pass)){
                System.out.println("Login Successfull");
                System.out.println("Welcome: " + p.getStudent_name());
                System.out.println("Role: Passenger");
                return;
            }
            
        }
        System.out.println("[Warning] Incorrect Student ID or password.");
    }
    
    public void registerDriver(){
        System.out.println("\n-----Register Driver-----");
        System.out.print("Enter your Student ID: ");
        String id = sc.nextLine();
        
        for (Driver d: Pemandu){
            if(d.getStudent_name().equalsIgnoreCase(id)){
                System.out.println("[WARNING] Student ID already registered. Please login instead.");
                return;
            }
        }
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("Phone Number: ");
        String notel = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Confirm Pass: ");
        String cpass = sc.nextLine();
        
        if(!pass.equals(cpass)){
            System.out.println("[!] Passwords do not match. Please try again.");
            return;
        }
        
        System.out.println("\n  -- Vehicle & License Info --");
        System.out.print("License No.   : "); 
        String lic   = sc.nextLine();
        System.out.print("Car Plate No. : "); 
        String plate = sc.nextLine();
        System.out.print("Car Model     : ");
        String model = sc.nextLine();
        System.out.print("Car Color     : ");
        String color = sc.nextLine();
    }
    
    public void registerPassenger(){
        System.out.println("\n-----Register Passenger-----");
        System.out.print("Enter your Student ID: ");
        String id = sc.nextLine();
         for (Passenger p: penumpang){
            if(p.getStudent_name().equalsIgnoreCase(id)){
                System.out.println("[WARNING] Student ID already registered. Please login instead.");
                return;
            }
        }
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("Phone Number: ");
        String notel = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Confirm Pass: ");
        String cpass = sc.nextLine();
         
        Passenger p = new Passenger("01",id,name,notel,pass);
        penumpang.add(p);
        System.out.println(p);
         
    }
}
