/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.Scanner;

/**
 *
 * @author harir
 */
public class StudentMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student[] stud = new Student[8];

        stud[0] = new Student(25, "John Dow", 'M', true, 90);
        stud[1] = new Student(21, "Jane Dow", 'F', true, 60);
        stud[2] = new Student(23, "Will Beyoan", 'M', false, 39);
        stud[3] = new Student(30, "Smith C", 'M', false, 45);
        stud[4] = new Student(19, "John Wick ", 'M', false, 12);
        stud[5] = new Student(18, "Donnal Young", 'M', true, 55);
        stud[6] = new Student(17, "Tavarish A", 'M', false, 8);
        stud[7] = new Student(27, "Isabella", 'F', false, 43);

        for (int i = 0; i < stud.length; i++) {
            System.out.println("\n<<<< Student " + (i + 1) + ">>>>");
            System.out.println("Name : " + stud[i].getName());
            System.out.println("Age : " + stud[i].getAge());
            System.out.println("Gender : " + stud[i].getGender());
            if (stud[i].getFlag() == true) {
                System.out.println(stud[i].getName() + " pass OOP Subject, Good Job!!");
            } else {
                System.out.println(stud[i].getName() + " fail OOP Subject, See You next Sem!!");
            }
        }

        //minimum and maximum ages
        int minAge = stud[0].getAge();
        int maxAge = stud[0].getAge();
        String minName = stud[0].getName();
        String maxName = stud[0].getName();

        for (int i = 0; i < stud.length; i++) {
            if (stud[i].getAge() < minAge) {
                minAge = stud[i].getAge();
                minName = stud[i].getName();
            }
            if (stud[i].getAge() > maxAge) {
                maxAge = stud[i].getAge();
                maxName = stud[i].getName();
            }
        }

        System.out.println("\n<< Minimum And Maximum Age Value >> ");
        System.out.println("Youngers => " + minName + minAge);
        System.out.println("Olders => " + maxName + maxAge);

        System.out.println("Enter Student Name : ");
        String nama = sc.nextLine();

        for (int i = 0; i < stud.length; i++) {
            if (stud[i].getName().equalsIgnoreCase(nama)) {
                System.out.println(stud[i].getName() + " Profile:-");
                System.out.println("-----------------------------");
                System.out.println("Age : " + stud[i].getAge());
                System.out.println("Sex : " + stud[i].getGender());

                if (stud[i].getFlag() == true) {
                    System.out.println("Result : " + "He PASS OOP Subject");
                } else {
                    System.out.println("Result : " + "He FAIL OOP Subject");
                }

            }
        }

        //fail group
        int passCount =0;

        System.out.println("\nList Of PASS Students");
        for (int i = 0; i < stud.length; i++) {
            

            if (stud[i].getFlag() == true) {
                passCount++;
                System.out.println((i + 1) + stud[i].getName() + "," + stud[i].getMark() + "Marks");
            }
  
        }
      
        
        double passPercent = (passCount * 100.0) / stud.length;
        System.out.println("TOTAL => " + passPercent);
        
        int failCount = 0;
        System.out.println("\nList Of Fail Students");
        
        for (int i = 0; i < stud.length; i++) {
            

            if (stud[i].getFlag() == false) {
                failCount++;
                System.out.println((i + 1) +  stud[i].getName() + " , " + stud[i].getMark() + " Marks");
            }
            

        }
        double failPercentage = (failCount * 100.0) / stud.length;
        System.out.println("TOTAL => " + failPercentage + " %");

    }
}
