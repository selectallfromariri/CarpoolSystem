/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CB25156;

/**
 *
 * @author harir
 */
public class Library {
    private String libraryName;
    private Book[] books;
    
    public Library(String libraryName, Book[] books){
        this.libraryName = libraryName;
        this.books = books;
    }
    
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
    
        
    public void displayLibrary(){
        System.out.println("Display Library : " + libraryName);
        for(int i = 0; i < books.length; i++){
            books[i].displayBook();
        }
    }
    
    public void displayMalaysiaBook(){
        System.out.println("Display Malaysia Library : " + libraryName);
        for(int i = 0; i < books.length; i++){
            if(books[i].getAuthor().getCountry().equalsIgnoreCase("Malaysia"))
                books[i].displayBook();
        }
    }
    
    

    
}
