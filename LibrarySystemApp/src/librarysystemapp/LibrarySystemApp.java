/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystemapp;

import java.util.Scanner;

/**
 *
 * @author harir
 */
public class LibrarySystemApp {

    private Library library;
    private Scanner sc;

    /**
     * @param args the command line arguments
     */
    public LibrarySystemApp() {
        sc = new Scanner(System.in);
        library = new Library("UMPSA Library", new Book[0]);
    }

    public static void main(String[] args) {

        LibrarySystemApp app = new LibrarySystemApp();
        app.menu();
//        Book b1 = new Book("B101", "Java Book", 2020, "Ali", "Malaysia");
//        Book b2 = new Book("B102", "OOP Concept", 2021, "Siti", "Singapura");
//        Book b3 = new Book("B103", "Data Structure", 2022, "Ahmad", "Malaysia");
//        
//        Book[] booklist = {b1, b2, b3};
//        
//        Library lib1 = new Library("UMPSA Library", booklist);
//        System.out.println("\n==================");
//        lib1.displayLibrary();
//        System.out.println("\n==================");
//        lib1.displayMalaysiaBook();
//        System.out.println("\n");
//        b2.updateAuthorCountry("Indonesia");
//        System.out.println("===After Updating Author Country ===");
//        lib1.displayLibrary();

    }

    public void menu() {
        int choice;

        do {
            System.out.println("\n========== Library System Menu =================");
            System.out.println("1. Enter Book Information");
            System.out.println("2. Display All Book");
            System.out.println("3. Display local and recent books");
            System.out.println("4. Calculate total late fees");
            System.out.println("5. Perform special actions");
            System.out.println("6. Sort books by year published");
            System.out.println("7. Dsiplay Books Type Summary Report");
            System.out.println("8. Display Detailed Type Report ");
            System.out.println("9. Display Fine Category Type");

            System.out.println("7. Exit");
            System.out.println("\n Enter your choices");
            choice = sc.nextInt();
            sc.skip("\\R?");

        } while (choice != 7);
    }

    public void enterBookInformation() {
        System.out.println("Enter total number of books");
        int totalBooks = sc.nextInt();
        sc.skip("\\R?");

        Book[] books = new Book[totalBooks];

        for (int i = 0; i < books.length; i++) {
            System.out.println("Enter Information for Book " + (i + 1));
            System.out.println("Book ID : ");
            String booksID = sc.nextLine();
            System.out.println("Title : ");
            String title = sc.nextLine();
            System.out.println("Year Published : ");
            String year = sc.nextLine();
            System.out.println("Author Name: ");
            String authorname = sc.nextLine();
            System.out.println("Country : ");
            String country = sc.nextLine();

            int type;
            do {
                System.out.println("Book Type: " + "\t\n1) Printed Book" + "\t\n2) EBook" + "\t\nEnter Type: ");
                type = sc.nextInt();

                if (type != 1 && type != 2) {
                    System.out.println("Invalid type. Please Enter 1 or 2");
                }
            } while (type != 1 && type != 2);

            if (type == 1) {
                System.out.println("Page Count: ");
                int pageCount = sc.nextInt();
                sc.skip("\\R?");
                books[i] = new PrintedBook(booksID, title, type, authorname, country, pageCount);
            } else {
                System.out.println("File Size (MB): ");
                double fileSize = sc.nextDouble();
                sc.skip("\\R?");
                books[i] = new EBook(booksID, title, type, authorname, country, fileSize);
            }
        }
        library.setBooks(books);
        System.out.println("Book information has benn entered successfully!");
    }

    public void calculateTotalLateFee() {
        if (library.getBooks() == null || library.getBooks().length == 0) {
            System.out.println("No books available in the library");
            return;
        }
        System.out.println("Enter Number Of Late Days: ");
        int days = sc.nextInt();

        double total = library.calculateTotalLateFees(days);
        System.out.println("Total Late Fees: RM" + total);
    }

    public void sortBooksbyYear() {
        if (library.getBooks() == null || library.getBooks().length == 0) {
            System.out.println("No books available in the library");
            return;
        }
        library.performSpecialActions();
        library.displayLibrary();
    }

    public void displayAllBooks() {
        if (library.getBooks() == null || library.getBooks().length == 0) {
            System.out.println("No books available in the library");
            return;
        }
        library.displayLibrary();;
    }

    public void displayLocalRecentBooks() {
        if (library.getBooks() == null || library.getBooks().length == 0) {
            System.out.println("No books available in the library");
            return;
        }
        library.displayLocalRecentBooks();
    }

    public void performSpecialAction() {
        if (library.getBooks() == null || library.getBooks().length == 0) {
            System.out.println("No books available in the library");
            return;
        }
        library.performSpecialActions();
    }
    public void displayBookTypeSummaryReport(){
        if(library==  null){
            System.out.println("No Books Available in the Library");
        }else{
            LibraryReport report = new LibraryReport(library.getBooks());
            report.displayBookTypeSummary();
        }
    }
    public void dispayBookDetailedTypeReport(){
        if(library==  null){
            System.out.println("No Books Available in the Library");
        }else{
            LibraryReport report = new LibraryReport(library.getBooks());
            report.DisplayDetailedTypeReport();
        }      
    }
        public void displayFineCategoryreport(){
        if(library==  null){
            System.out.println("No Books Available in the Library");
        }else{
            System.out.println("Enter days late : ");
            int late = sc.nextInt();
            LibraryReport report = new LibraryReport(library.getBooks());
            report.displayFineCategoryReport(late);
        } 
}
}
