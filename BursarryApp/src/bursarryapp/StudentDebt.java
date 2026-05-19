/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bursarryapp;

/**
 *
 * @author harir
 */
public class StudentDebt {
    private double libraryDebt;
    private double stduyFeeDebt;
    
    public StudentDebt(double libraryDebt, double studyFeeDebt){
        this.libraryDebt = libraryDebt;
        this.stduyFeeDebt = studyFeeDebt;
    }

    public double getLibraryDebt() {
        return libraryDebt;
    }

    public double getStduyFeeDebt() {
        return stduyFeeDebt;
    }

    public void setLibraryDebt(double libraryDebt) {
        this.libraryDebt = libraryDebt;
    }

    public void setStduyFeeDebt(double stduyFeeDebt) {
        this.stduyFeeDebt = stduyFeeDebt;
    }
    
    
    public double getTotalDebt(){
        double tot = getStduyFeeDebt() + getLibraryDebt();
        return tot;
    }
}
