/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bursarryapp;
import java.util.Scanner;

/**
 *
 * @author harir
 */
public class Student {
    private String name;
    private PersonalInformation personalInfo;
    private StudentDebt debt;
    
    public Student(String name, String matricNum, char gender, StudentDebt debt){
        this.name = name;
        this.debt = debt;
        this.personalInfo = new PersonalInformation(matricNum, gender);
    }

    public String getName() {
        return name;
    }

    public PersonalInformation getPersonalInfo() {
        return personalInfo;
    }

    public StudentDebt getDebt() {
        return debt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setDebt(StudentDebt debt) {
        this.debt = debt;
    }
    
    
        //location
    public String Location(){
        String location = personalInfo.getMatricNum().substring(2, 4);
        String year;
        if(location.equalsIgnoreCase("23")){
            return year = "2023";
        }else if(location.equalsIgnoreCase("24")){
            return year = "2024";
        }else if(location.equalsIgnoreCase("18")){
            return year = "1918";
        }else if(location.equalsIgnoreCase("22")){
            return year = "2022";
        }else if(location.equalsIgnoreCase("21")){
            return year = "2021";
        }else{
            return year = "Unknown";
        }
    }
    
    
    public void displayStudent(){
        char gen = personalInfo.getGender();
        String genders; 
        
        if(gen == 'M'){
            genders = "Male";
        }else if(gen == 'F'){
            genders = "Female";
        }else{
            genders = "Unknown";
        }
        System.out.println("Student Name : " + getName());
        System.out.println("Matric Number : " + personalInfo.getMatricNum());
        System.out.println("Acedemic Program : " + personalInfo.getProgram());
        System.out.println("Gender : " + genders);
        System.out.println("Total Debt : " + debt.getTotalDebt());
        System.out.println("Year Start : " + Location());
    }
    
    public void searchName(Student[] student, String name){
        for(int i = 0; i< student.length; i++){
            if(student[i].getName().contains(name)){
                student[i].displayStudent();
            }
        }
    }
    
    //highest debt
    public void highestDebt(Student[] student){
        double highest = student[0].debt.getTotalDebt();
        int index = 0;
        for(int i = 0;i < student.length; i++){
            if(student[i].debt.getTotalDebt() > highest){
                highest = student[i].debt.getTotalDebt();
                index = i;
                
            }
        }
        System.out.println("Highest Shit is : ");
        student[index].displayStudent();
        
    }
    
    //lowest
    public void lowestDebt(Student[] student){
        double lowest = student[0].debt.getTotalDebt();
        int index = 0;
        for(int i = 0; i < student.length; i++){
            if(student[i].debt.getTotalDebt() < lowest){
                lowest = student[i].debt.getTotalDebt();
                index = i;
            }
        }
        System.out.println("Student with lowest Shit : " );
        student[index].displayStudent();
    }
    
    public void updateName(String change){
        setName(change);
    }
    
    public double averageDebt(Student[] student){
        
        double avg = 0;
        for(int i = 0;i < student.length; i++){
            avg = student[i].debt.getTotalDebt() / student.length;
        }
        return avg;
    }
}