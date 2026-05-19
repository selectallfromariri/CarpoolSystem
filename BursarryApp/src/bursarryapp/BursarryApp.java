/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bursarryapp;
import java.util.Scanner;
/**
 *
 * @author harir
 */
public class BursarryApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Student[] student = new Student[6];
       
       StudentDebt debt1 = new StudentDebt(2.20, 500.60);
       StudentDebt debt2 = new StudentDebt(0.0, 0.0);
       StudentDebt debt3 = new StudentDebt(0.0, 909.20);
       StudentDebt debt4 = new StudentDebt(0.0, 0.0);
       StudentDebt debt5 = new StudentDebt(20.90, 1500.10);
       StudentDebt debt6 = new StudentDebt(12.80, 0.0);
       
       
       student[0] = new Student("Yen Chi-tan","CD23818", 'M', debt1);
       student[1] = new Student("Aariz Hassan","CB24001", 'M', debt2);
       student[2] = new Student("Mohana Muniandy","CA23476", 'F', debt3);
       student[3] = new Student("Richard Harris","CD18983", 'M', debt4);
       student[4] = new Student("Saw Yee Fung","CB22492", 'F', debt5);
       student[5] = new Student("Mashud Hamsa ","CB21013", 'M', debt6);
       
       
//       ///display all
//       for(int i = 0; i< student.length; i++){
//           student[i].displayStudent();
//       }
//       
      //display only have debt
      double count = 0;
      double totalDebt = 0;
      for(int i = 0; i < student.length; i++){
          if(student[i].getDebt().getTotalDebt() > 0){
              count++;
              student[i].displayStudent();
              totalDebt += student[i].getDebt().getTotalDebt();
              
          }
      }
        System.out.println("\n===================");
        System.out.println("Total Student With Debt : " + count);
        System.out.println("Total Amount Of Student Debt : " + totalDebt);
        
      //display only name insert
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        
        student[0].searchName(student, name);
        
        
        System.out.println("\n=========================");
        System.out.println("HIGHEST DEBT");
        student[0].highestDebt(student);
        
        System.out.println("\n=================");
        System.out.println("Lowest Shit");
        student[0].lowestDebt(student);
        
        //change name
        System.out.println("Enter name to change : ");
        String change = sc.nextLine();
        
        student[0].updateName(change);
        
        System.out.println("\n=====================");
        System.out.println("AFTER UPDATE");
        
        for(int i = 0; i < student.length; i++){
            student[i].displayStudent();
        }
        
        System.out.println("\n\nTHIS IS THE AVERAGE DEBT : ");
        System.out.println("======================");
        double avg = student[0].averageDebt(student);
        System.out.println("This is the avg : " + avg);
        
        
        
    }
    
}
