/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mycards;
import java.util.Scanner;
/**
 *
 * @author harir
 */
public class MyCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter MyCard");
        String ic = sc.next();
        MyKad Mycard = new MyKad(ic);
        
        
        System.out.println("<< MyKad Info >>");
        System.out.println("\nDay : " + Mycard.readDay());
        System.out.println("Month : " + Mycard.readMonth());
        System.out.println("Year : " + Mycard.readYear());
        System.out.println("Gender : " + Mycard.readGender());
        System.out.println("Place Of Birth : " + Mycard.readPOB());
        
        
    }
    
}
