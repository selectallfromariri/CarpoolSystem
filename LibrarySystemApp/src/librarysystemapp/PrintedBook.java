/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemapp;

/**
 *
 * @author harir
 */
public class PrintedBook extends Book {
    
    private int pageCount;
    
    public PrintedBook(String BookID, String title, int yearPublished, String author, String country, int pageCount){
        super(BookID, title, yearPublished, author, country);
        this.pageCount = pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public int getPageCount() {
        return pageCount;
    }
    
    public int estimateReadingtTime(){
        return pageCount* 2;
    }
    public void performSpeacialAction(){
        System.out.println("Reading time : " + estimateReadingtTime() + " Minutes");
    }
    public void displayBook(){
        super.displayBook();
        System.out.println("Book Type : Printed Book");
        System.out.println("Page Count : " + pageCount);
    }
    public double calcLateFee(int days){
        return days * 2;
    }
}
