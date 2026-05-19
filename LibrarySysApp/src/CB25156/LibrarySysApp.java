/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CB25156;

/**
 *
 * @author harir
 */
public class LibrarySysApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book[] booklet = new Book[3];
        AuthorProfile author1 = new AuthorProfile("Ali", "Malaysia");
        AuthorProfile author2 = new AuthorProfile("Siti", "Singapura");
        AuthorProfile author3 = new AuthorProfile("Ahmad", "Malaysia");
        booklet[0] = new Book("B101", "Java Basic", 2020, author1);
        booklet[1] = new Book("B102", "OOP Concept", 2021, author2);
        booklet[2] = new Book("B103", "Data Structure", 2022, author3);
          
        Library lib1 = new Library("UMPSA", booklet);
//        
//        lib1.displayLibrary();
//        
//        booklet[1].updateAuthorCountry("Indonesia");
//        
//        lib1.displayLibrary();
        
        lib1.displayMalaysiaBook();
        
        
        
        
        
    }
    
}
