/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemapp;

/**
 *
 * @author harir
 */
public class Book {
    protected String BookID;
    protected String title;
    protected int yearPublished;
    protected AuthorProfile author; // assosiation (has a relay
    
    public Book(String bookID, String title, int yearPublished, String author, String country){
        this.BookID = bookID;
        this.author =  new AuthorProfile(author, country);
        this.title = title;
        this.yearPublished = yearPublished;
    }
    
    
    
    public void displayBook(){
        System.out.println("Book ID : " + BookID);
        System.out.println("Title : " + title);
        System.out.println("Yar published : " + yearPublished);
        System.out.println("Author : " + getAuthor().getAuthorName());
        System.out.println("Country : " + getAuthor().getCountry());
    }

    /**
     * @return the BookID
     */
    public String getBookID() {
        return BookID;
    }

    /**
     * @param BookID the BookID to set
     */
    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * @param yearPublished the yearPublished to set
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * @return the author
     */
    public AuthorProfile getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(AuthorProfile author) {
        this.author = author;
    }
    public void updateAuthorCountry(String newCountry){
        getAuthor().setCountry(newCountry);
    }

    public double calcLateFee(int days){
        return days + 1;
    }
    public boolean isRecentBook(){
        return yearPublished >= 2020;
    }
    public void performSpecialAction(){
        System.out.println("No Special Action");
    }
    
    
    
    
}
