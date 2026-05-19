/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bursarryapp;

/**
 *
 * @author harir
 */
public class PersonalInformation {
    private String matricNum;
    private char gender;
    
    public PersonalInformation(String matricNum, char gender){
        this.matricNum = matricNum;
        this.gender = gender;
    }

    public String getMatricNum() {
        return matricNum;
    }

    public char getGender() {
        return gender;
    }

    public void setMatricNum(String matricNum) {
        this.matricNum = matricNum;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    

    public String getProgram(){
        String matric = matricNum.substring(0, 2);
        String program;
        
        if(matric.equalsIgnoreCase("CA")){
            return program = "Computer System & Networking";
        }else if(matric.equalsIgnoreCase("CB")){
            return program = "Software Engineering";
        }else if(matric.equalsIgnoreCase("CD")){
            return program = "Graphics & Multimedia Technology";
        }else{
            return program = "Unknown";
        }
    }
}
