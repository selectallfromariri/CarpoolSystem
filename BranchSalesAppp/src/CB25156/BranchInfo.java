/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CB25156;
import java.util.Scanner;
/**
 *
 * @author harir
 */
public class BranchInfo {
    private String branchOwner;
    private String branchManager;
    private int numStaff;
    private int totalCustomer;
    private double totalSales;
    private String branchCode;
    
    public BranchInfo(String branchOwner, String branchManager, int numStaff, int totalCustomer, double totalSales, String branchCode){
        this.branchOwner = branchOwner;
        this.branchManager = branchManager;
        this.numStaff = numStaff;
        this.totalCustomer = totalCustomer;
        this.totalSales = totalSales;
        this.branchCode = branchCode;
    }

    public String getBranchOwner() {
        return branchOwner;
    }


    public void setBranchOwner(String branchOwner) {
        this.branchOwner = branchOwner;
    }

    public String getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(String branchManager) {
        this.branchManager = branchManager;
    }

    public int getNumStaff() {
        return numStaff;
    }

    public void setNumStaff(int numStaff) {
        this.numStaff = numStaff;
    }

    public int getTotalCustomer() {
        return totalCustomer;
    }


    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer = totalCustomer;
    }


    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    
    public String branchcodeState(){
        String state = getBranchCode().substring(0, 3);
        String stateName;
        if(state.equalsIgnoreCase("SAB")){
            return stateName = "Sabah";
        }else if(state.equalsIgnoreCase("SWK")){
            return stateName = "Sarawak";
        }else if(state.equalsIgnoreCase("JHR")){
            return stateName = "Johor";
        }else if(state.equalsIgnoreCase("PHG")){
            return stateName = "Pahang";
        }else if(state.equalsIgnoreCase("WLP")){
            return stateName = "Wilayah Persekutuan";
        }else if(state.equalsIgnoreCase("KDH")){
            return stateName = "Kedah";
        }else{
            return stateName = "Unknown";
        }
    }
    
    public String branchCodeCity(){
        String city = getBranchCode().substring(3, 6);
        String cityName;
        if(city == "KKI"){
            return cityName = "Kota Kinabalu";
        }else if(city.equalsIgnoreCase("TWU")){
            return cityName = "Tawau";
        }else if(city.equalsIgnoreCase("KCH")){
            return cityName = "Kuching";
        }else if(city.equalsIgnoreCase("SMR")){
            return cityName = "Sumarahan";
        }else if(city.equalsIgnoreCase("JBR")){
            return cityName = "Johor Baharu";
        }else if(city.equalsIgnoreCase("BPT")){
            return cityName = "Batu Pahat";
        }else if(city.equalsIgnoreCase("Kua")){
            return cityName = "Kuantan";
        }else if(city.equalsIgnoreCase("PKN")){
            return cityName = "Pekan";
        }else if(city.equalsIgnoreCase("PJY")){
            return cityName = "Putrajaya";
        }else if(city.equalsIgnoreCase("LBN")){
            return cityName = "Labuan";
        }else if(city.equalsIgnoreCase("AOR")){
            return cityName = "Alor Setar";
        }else if(city.equalsIgnoreCase("SPN")){
            return cityName = "Sungai Petani";
        }else{
            return cityName = "Unknown";
        }
    }
    
    public void printBranchInfo(){
        System.out.println("Branch Code : " + getBranchCode());
        System.out.println("Branch Location : " + branchCodeCity() + ", " + branchcodeState());
        String opening = getBranchCode().substring(6,10);
        System.out.println("Opening Year : " + opening);
        System.out.println("Branch No : ");
        System.out.println("Owner Name : " + getBranchOwner());
        System.out.println("Manager Name : " + getBranchManager());
        System.out.println("No . Off Staff : " + getNumStaff());
        System.out.println("Total Customer : " + getTotalCustomer());
        System.out.println("Total Sales : " + getTotalSales());
    }
    
    public double calcTotalSale(BranchInfo[] branch){
        double sales = 0;
        for(int i = 0; i < branch.length; i++){
            sales += branch[i].getTotalSales();
        }
        return sales;
    }
    
    public double calcSaleAverage(double sum, BranchInfo[] branch){
        double sales = 0;
        double average = 0;
        double count = 0;
        for(int i = 0; i < branch.length; i++){
            count++;
            sales += branch[i].getTotalSales();
            average = sales / count;
        }
        return average;
    }
    
    public void getHighestSale(BranchInfo[] branch){
        double highest = branch[0].getTotalSales();
        int index = 0;
        for(int i = 0; i < branch.length; i++){
            if(branch[i].getTotalSales() > highest){
                highest = branch[i].getTotalSales();
                index = i;
                
            }
            
                
        }
        System.out.println("branch witht he highest sale is " + branch[index].getBranchCode() + " with total sales of" + branch[index].getTotalSales());
        
    }
    
    public void getLowestCustomer(BranchInfo[] branch){
        double Lowest = branch[0].getTotalCustomer();
        int index = 0;
        
        for(int i = 0; i < branch.length; i++){
            if(branch[i].getTotalCustomer() < Lowest){
                Lowest = branch[i].getTotalCustomer();
                index = i;
                
                
            }
        }
        System.out.println("Branch with lowest customer is " + branch[index].getBranchCode() + " with total customer of " + branch[index].getTotalCustomer());
    }
    
    public void searchByOwner(BranchInfo[] branch){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Branch Owner : ");
        String name = sc.nextLine();
        
        for(int i = 0; i < branch.length; i++){
            if(branch[i].getBranchOwner().contains(name)){
                branch[i].printBranchInfo();
            }
        }
        
        
        
    }
    
    
    
}
