/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemapp;

/**
 *
 * @author harir
 */
public class EBook extends Book {

    private double fileSize;

    public EBook(String BookID, String title, int yearPublished, String author, String country, double fileSize){
        super(BookID, title, yearPublished, author, country);
        this.fileSize = fileSize;
    

}

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }
    
    public boolean isLargeFile(){
        return fileSize>50;
    }
    public double calcDebtFee(int days){
        return days*0.5;
    }
    public void performSpecialAction(){
        System.out.println("Is Large File : " + isLargeFile()); 
    }
    public void displayBook(){
        super.displayBook();
        System.out.println("Book Type : EBook");
        System.out.println("Page Count : " + fileSize + " MB");
    }

}
