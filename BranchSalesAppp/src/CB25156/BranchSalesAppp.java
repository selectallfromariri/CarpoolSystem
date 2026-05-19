/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CB25156;
import java.util.Scanner;
/**
 *
 * @author harir
 */
public class BranchSalesAppp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BranchInfo[] branch = new BranchInfo[5];
        
        branch[0] = new BranchInfo("Aariz Hassan", "Joshua Ng", 25, 1000, 35000, "WLPPJY2002");
        branch[1] = new BranchInfo("Aqeel Hussain", "Lydiawati", 30, 1200, 45000, "KDHAOR2101");
        branch[2] = new BranchInfo("Fatimah Nurul", "Nadia", 20, 1300, 55000, "PHGPKN2202");
        branch[3] = new BranchInfo("Liu Yifei", "Iman", 15, 1400, 65000, "JHRBPT1903");
        branch[4] = new BranchInfo("Ravi Subramanian", "Anas", 20, 1500, 75000, "SWKKCH2003");
        
        
        for(int i = 0; i < branch.length; i++){
            System.out.println("\n====================");
            branch[i].printBranchInfo();
            System.out.println("======================");
        }
        
        
        System.out.println("\n===================");
            double sales = branch[0].calcTotalSale(branch);
            System.out.println("Total Sale : " + sales);
        System.out.println("===================");
        
        System.out.println("\n===================");
            double avg = branch[0].calcSaleAverage(0, branch);
            System.out.println("Average Sale " + avg);
        System.out.println("===================");
        
        
        System.out.println("\n===================");
            branch[0].getHighestSale(branch);
        System.out.println("===================");
        
        System.out.println("\n===================");
            branch[0].getLowestCustomer(branch);
        System.out.println("===================");
        
        System.out.println("\n===================");
        branch[0].searchByOwner(branch);
        System.out.println("===================");
       
    }
    
}
