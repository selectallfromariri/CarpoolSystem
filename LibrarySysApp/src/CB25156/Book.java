/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CB25156;

/**
 *
 * @author harir
 */
public class Book {

    private String bookID;
    private String title;
    private int yearPublished;
    private AuthorProfile author;

    public Book(String bookID, String title, int yearPublished, AuthorProfile author) {
        this.title = title;
        this.bookID = bookID;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public AuthorProfile getAuthor() {
        return author;
    }

    public void setAuthor(AuthorProfile author) {
        this.author = author;
    }
    
    public void displayBook(){
        System.out.println("Book ID : " + getBookID());
        System.out.println("Title : " + getTitle());
        System.out.println("Year Published : " + getYearPublished());
        System.out.println("Author : " + author.getAuthorName());
        System.out.println("Author : " + author.getCountry());
    }
    
    public void updateAuthorCountry(String country){
        author.setCountry(country);
    }

}
