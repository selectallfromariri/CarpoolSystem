/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemapp;

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
    public void setLibraryName(String libraryName){
        this.libraryName = libraryName;
    }
    public void setBooks (Book[] books){
        this.books = books;
    }
    public String getLibrary(){
        return libraryName;
    }
    public Book[] getBooks(){
        return books;
    }
    
    public void displayLibrary(){
        System.out.println("List of Book");
        for(int i = 0; i < books.length; i++){
            books[i].displayBook();
            System.out.println("==============");
        }
    }
    public void displayMalaysiaBook(){
        System.out.println("All Book By Malaysiam");
        for(int i = 0;i < books.length; i++){
            if(books[i].getAuthor().getCountry().equalsIgnoreCase("Malaysia")){
                books[i].displayBook();
                System.out.println("==============");
            }
        }
    }
    public void displayLocalRecentBooks(){
        System.out.println("\n Local and Recent Books");
        boolean found = false;
        
        for(int i = 0; i < books.length; i++){
            if(books[i].author.isLocalAuthor() && books[i].isRecentBook()){
                books[i].displayBook();
                found = true;
            }else{
                found = false;
                System.out.println("No recent book found");
            }
        }
    }
    public void sortBookByYear(){
        for(int i = 0; i < books.length; i++){
            for(int j = 0; j < books.length; j++){
                if(books[i].getYearPublished() > books[j+1].yearPublished){
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }
    public double calculateTotalLateFees(int days) {
        double total = 0;
        
        for (int i = 0; i < books.length; i++) {
            total += books[i].calcLateFee(days);
        }
        return total;
    }
    public void performSpecialActions() {
        System.out.println("\nSpecial Action: ");
        
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book ID: " + books[i].getBookID());
            books[i].performSpecialAction();
            System.out.println("======================================================");
        }
    }
}
